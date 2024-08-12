/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author pc
 */
public class Bean_Paysheet {
    private String COLUMN_1;
    private String COLUMN_2;
    private String COLUMN_3;
    private String COLUMN_4;
    

    public Bean_Paysheet(String COLUMN_1, String COLUMN_2, String COLUMN_3, String COLUMN_4) {
        this.COLUMN_1 = COLUMN_1;
        this.COLUMN_2 = COLUMN_2;
        this.COLUMN_3 = COLUMN_3;
        this.COLUMN_4 = COLUMN_4;
        
    }

   
 
    public String getCOLUMN_1() {
        return COLUMN_1;
    }

   
    public void setCOLUMN_1(String COLUMN_1) {
        this.COLUMN_1 = COLUMN_1;
    }

   
    public String getCOLUMN_2() {
        return COLUMN_2;
    }

    
    public void setCOLUMN_2(String COLUMN_2) {
        this.COLUMN_2 = COLUMN_2;
    }

    
    public String getCOLUMN_3() {
        return COLUMN_3;
    }

    
    public void setCOLUMN_3(String COLUMN_3) {
        this.COLUMN_3 = COLUMN_3;
    }

    
    
    public String getCOLUMN_4() {
        return COLUMN_4;
    }

    
    public void setCOLUMN_4(String COLUMN_4) {
        this.COLUMN_4 = COLUMN_4;
    }
    
}

