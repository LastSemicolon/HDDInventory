/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hddinventory;

/**
 *
 * @author linkxs
 */
public class HddInventory {
    private static PrimaryInterface pi;
    private static DataTableHandler dth;
    
    public static void main(String[] args) {
       pi = new PrimaryInterface();
       dth = new DataTableHandler(pi);
       
       pi.setVisible(true);
    }
}
