/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import ArchivosProyecto.ImageHandler;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Moisés
 */
public class JPEGtoBMPImage extends ImageHandler{
    
    private BufferedImage bi;

    public JPEGtoBMPImage(String filename) {
        super(filename);
    }

    @Override
    public void readFile() throws Exception {
        System.out.println("Imagen leida: " + this.handledFileName);
        File file = new File(this.handledFileName);
        bi = ImageIO.read(file);
    }

    @Override
    public void generateFiles() throws Exception {
        if (this.handledFileName.endsWith(".jpg")) {
           int indexBarra = this.handledFileName.lastIndexOf("\\");
           int indexPunto = this.handledFileName.lastIndexOf(".");
           String nuevoNombre = this.handledFileName.substring(indexBarra, indexPunto)+ ".bmp";
           File nuevoArchivo= new File("./Temporal/" + "converted-" + nuevoNombre);
           new File(nuevoArchivo.getParent()).mkdirs();
           ImageIO.write(bi, "bmp", nuevoArchivo);
        } else{
           int indexBarra = this.handledFileName.lastIndexOf("\\");
           int indexPunto = this.handledFileName.lastIndexOf(".");
           String nuevoNombre = this.handledFileName.substring(indexBarra, indexPunto)+ ".jpg";
           File nuevoArchivo= new File("./Temporal/" + "converted-" + nuevoNombre);
           new File(nuevoArchivo.getParent()).mkdirs();
           ImageIO.write(bi, "jpg", nuevoArchivo);             
        
        }
  
    }
    
}
