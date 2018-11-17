/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GpioAccess;

import gpio.Interfaces.IControler;
import oszyloskop.IStateReader;

/**
 *
 * @author marian
 */
public class GpioStateReader implements IStateReader {

    public GpioStateReader(IControler controler, int pin){
        _controler = controler;
        _pin = pin;
    }
    
    @Override
    public boolean getState() throws Exception {
        return _controler.getState(_pin);
    }
    
    private int _pin;
    private IControler _controler;
}
