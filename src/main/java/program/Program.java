/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import Output.InterpretingConsoleRecordsink;
import GpioAccess.GpioStateReader;
import gpio.ControlerFactory;
import oszyloskop.IStateReader;
import oszyloskop.LogicOszyloscop;

/**
 *
 * @author marianp
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        int inputPin = 0;          
        try{
           inputPin = getPinNumber(args);           
        }catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }        
        
        System.out.println(inputPin);
        IStateReader stateReader = new GpioStateReader(ControlerFactory.getInstance(),
                                    inputPin);
                
        LogicOszyloscop logicOszyloscop = new LogicOszyloscop(stateReader, 
                new InterpretingConsoleRecordsink());
        logicOszyloscop.DisableRecordTime();
        
        logicOszyloscop.run();
    }
    
    
    private static int getPinNumber(String[] args) throws Exception{
        if(args.length != 1){
            throw new Exception("Angeschlossener Pin nicht übergen");
        } 
         
        try{
           return Integer.parseInt(args[0]); 
        }catch(NumberFormatException e){
            throw new Exception("Kein valider pin übergeben.");
        }
    }
    
}
