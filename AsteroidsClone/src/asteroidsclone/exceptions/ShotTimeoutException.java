/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroidsclone.exceptions;

/**
 *
 * @author Daniel
 */
public class ShotTimeoutException extends Exception{
    
    // Exception type thrown by shots when they reach their tick limit
    public ShotTimeoutException(String message) {
        super(message);
    }
}
