package Output;

import oszyloskop.IRecordSink;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author marianp
 */
public class InterpretingConsoleRecordsink implements IRecordSink{

    @Override
    public void record(long timestamp, boolean state) {
        if(_lastTimestamp == null)
        {
            log("--startRecord-- " + timestamp + "  " + state);
            _lastTimestamp = timestamp;
            _lastState = state;
        }
        
        if(state != _lastState){
            log("Dauer: " + (timestamp - _lastTimestamp) + " State: " + _lastState);            
            _lastState = state;
            _lastTimestamp = timestamp;
        }
    }
    
    private void log(String out){
        System.out.println(out);
    }
    
    private Long _lastTimestamp = null;
    private boolean _lastState;
}
