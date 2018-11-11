/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oszyloskop;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marianp
 */
public class LogicOszyloscop implements Runnable{

    public LogicOszyloscop(IStateReader stateReader, IRecordSink recordSink) {
        _stateReader = stateReader;
        _recordSink = recordSink;
    }
    
    public void DisableRecordTime(){
        _recordtimeSet = false;
    }
    
    public void EnableRecordTime(){
        _recordtimeSet = true;
    }
    
    public void SetRecordTime(long time){
        _recordTime = time;
    }
    
    @Override
    public void run() {
        Long lastTimestamp = System.currentTimeMillis();
        
        while (true){
            long now = System.currentTimeMillis();
            
             if(_recordtimeSet &&  lastTimestamp < (now - _recordTime))   
                 continue;             
                          
            try {
                boolean state = _stateReader.getState();
                _recordSink.record(now, state);
                lastTimestamp = now;
            } catch (Exception ex) {
                Logger.getLogger(LogicOszyloscop.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
    }
    
    private IStateReader _stateReader;
    private IRecordSink _recordSink;
    
    private boolean _recordtimeSet = true;
    private long _recordTime = 1;
}
