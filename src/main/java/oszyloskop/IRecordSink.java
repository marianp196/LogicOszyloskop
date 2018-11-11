/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oszyloskop;

/**
 *
 * @author marianp
 */
public interface IRecordSink {
    void record(long timestamp, boolean state);
}
