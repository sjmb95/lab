/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_171103080;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Salim jaafar 171103080
 */
public class Lab1_171103080 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] p;
        Integer [] blockA ,blockB, blockC; // first fit bestfit worstfit
        int mem, numP,bSize;
        Scanner in = new Scanner(System.in);
        
        System.out.println("enter memory capacity");
        mem = in.nextInt();
        System.out.println("number of memory partition");
        bSize = in.nextInt();
        blockA = new Integer[bSize];
        blockB = new Integer[bSize];
        blockC = new Integer[bSize];
        
         for(int i=0;i< bSize;i++){
          System.out.println("enter size of partition "+(i+1));
          blockA[i] = in.nextInt(); 
         
        }
         blockB = Arrays.copyOf(blockA, bSize);
         blockC = Arrays.copyOf(blockA, bSize);

         
        Arrays.sort(blockB);                  // ascending order for bestfit
        Arrays.sort(blockC,Collections.reverseOrder()); // descending order for worstfit
        System.out.println("enter number of processes");
        numP =in.nextInt();   
        p = new int[numP][2];
        
        Integer [] blockTemp = new Integer[bSize];
       
        // FIRST FIT
         
        for(int i=0;i< numP;i++){
          System.out.println("enter size of process "+(i+1)+" ");
          p[i][0] = in.nextInt();
          
          int j = 0;
          while(j< bSize){
            if(p[i][0] < blockA[j]){
              p[i][1] = blockA[j] - p[i][0]; // internal fragmentation
              
              blockA[j] = Integer.parseInt("0");
              break;
            }else{
              p[i][1] = -1;
              j++;
            }
            
          }
         
        }
       
        System.out.println("\n*******FIRSTFIT*******");
        System.out.println("Process  Size  Internal Fragmentation");
        for(int i =0; i < numP;i++){
         
         System.out.println((i+1)+"         "+p[i][0]+"         "+p[i][1]);
        
        } 
        
        // WORST FIRST
      //    
          for(int i=0;i< numP;i++){
          
          int j = 0;
          while(j<bSize){
            if(p[i][0] <= blockC[j]){
              p[i][1] = blockC[j] - p[i][0];   // internal fragmentation
             
              blockC[j] = Integer.parseInt("0");
              break;
            }else{
                
                p[i][1] = -1; 
             j++;
            }
            
          }
        }
          
      
        System.out.println("\n*******WORSTFIT*******");
        System.out.println("Process  Size  Internal Fragmentation");
        for(int i =0; i < numP;i++){
         
         System.out.println((i+1)+"         "+p[i][0]+"         "+p[i][1]);
         
        } 
        
        // BEST FIRST
        
    
         
          for(int i=0;i< numP;i++){
            
          int j = 0;
          while(j<bSize){
            if(p[i][0] < blockB[j]){
              p[i][1] = blockB[j] - p[i][0];   // internal fragmentation
              blockB[j] = Integer.parseInt("0");
              
              break;
            }else{
               p[i][1] = -1; 
             j++;
            }
            
          }
        }
          
        
        System.out.println("\n*******BESTFIT*******"); 
        System.out.println("Process  Size  Internal Fragmentation");
        for(int i =0; i < numP;i++){
         
         System.out.println((i+1)+"         "+p[i][0]+"         "+p[i][1]);
        
        } 
       
       System.out.println(                               
       " \n           WORSTFIT ADVANTAGE\n"+
        "  Reduces production of small gaps\n"+
         " "+        
         "\n         WORSTFIT DISADVANTAGES\n"+
         " If process with larger memory arrives it cant be accomodated\n"+
         " "+         
           "\n       FIRSTFIT ADVANTAGES\n"+
          " Fastest algorithm searches only a little\n"+
           "\n       FIRSTFIT DISADVANTAGES\n"+
          " Rthe remaining memories are not usefull if they ae to small \n "+  
          "\n         BESTFIT ADVANTAGES\n"+
          "Memoy is utilized well because it searches smallest fit\n"+
          "\n        BESTFIT DISADVANTAGES\n"+
          "It is slow and may fill memory with holes \n" );  // comparism
        
        
        
    }
    
}
