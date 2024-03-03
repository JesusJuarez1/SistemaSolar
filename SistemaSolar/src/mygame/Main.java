package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.FastMath;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    public Spatial spatial_var = null;
    public Spatial sol_spatial = null;
    public Spatial orbita_mercurio = null;
    public Spatial mercurio_spatial = null;
    public Spatial orbita_venus = null;
    public Spatial venus_spatial = null;
    public Spatial orbita_tierra = null;
    public Spatial tierra_node = null;
    public Spatial tierra_spatial = null;
    public Spatial luna_spatial = null;
    public Spatial orbita_marte = null;
    public Spatial marte_spatial = null;
    public Spatial orbita_jupiter = null;
    public Spatial jupiter_spatial = null;
    

    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);//Creamos un objeto para modificar la configuración
        settings.setTitle("Sistema Solar");//Cambiamos el nombre del juego
        settings.setResolution(1280, 720);
        
        Main app = new Main();
        app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        flyCam.setRotationSpeed(2);
        flyCam.setMoveSpeed(2);
        
        //Nodos
        Node padre_cubo = new Node("padre_cubo");
        Node node_tierra = new Node("node_tierra");
        //Orbitas
        Node mercurio_orbita = new Node("orbita_mercurio");
        Node venus_orbita = new Node("orbita_venus");
        Node tierra_orbita = new Node("orbita_tierra");
        Node marte_orbita = new Node("orbita_marte");
        Node jupiter_orbita = new Node("orbita_jupiter");
        
        //Formas
        Sphere b = new Sphere(32, 32, 1f);
        Geometry sol_geom = new Geometry("sol_geom", b);
        Geometry mercurio_geom = new Geometry("mercurio_geom", b);
        Geometry venus_geom = new Geometry("venus_geom", b);
        Geometry tierra_geom = new Geometry("tierra_geom", b);
        Geometry luna_geom = new Geometry("luna_geom", b);
        Geometry marte_geom = new Geometry("marte_geom", b);
        Geometry jupiter_geom = new Geometry("jupiter_geom", b);
        
        //Texturas
        Texture texture_sol = assetManager.loadTexture("Textures/sol.jpg");
        Material mat_sol = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_sol.setTexture("ColorMap", texture_sol);
        Texture texture_mercurio = assetManager.loadTexture("Textures/mercurio.jpg");
        Material mat_mercurio = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_mercurio.setTexture("ColorMap", texture_mercurio);
        Texture texture_venus = assetManager.loadTexture("Textures/venus.jpg");
        Material mat_venus = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_venus.setTexture("ColorMap", texture_venus);
        Texture texture_tierra = assetManager.loadTexture("Textures/tierra.jpg");
        Material mat_tierra = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_tierra.setTexture("ColorMap", texture_tierra);
        Texture texture_luna = assetManager.loadTexture("Textures/luna.jpg");
        Material mat_luna = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_luna.setTexture("ColorMap", texture_luna);
        Texture texture_marte = assetManager.loadTexture("Textures/marte.jpg");
        Material mat_marte = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_marte.setTexture("ColorMap", texture_marte);
        Texture texture_jupiter = assetManager.loadTexture("Textures/jupiter.jpg");
        Material mat_jupiter = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_jupiter.setTexture("ColorMap", texture_jupiter);
        
        
        //Añadir texturas
        sol_geom.setMaterial(mat_sol);
        mercurio_geom.setMaterial(mat_mercurio);
        venus_geom.setMaterial(mat_venus);
        tierra_geom.setMaterial(mat_tierra);
        luna_geom.setMaterial(mat_luna);
        marte_geom.setMaterial(mat_marte);
        jupiter_geom.setMaterial(mat_jupiter);
        
        
        //Añadir formas al nodo padre
        sol_geom.rotate(-FastMath.HALF_PI, 0, 0);
        padre_cubo.attachChild(sol_geom);
        mercurio_geom.rotate(-FastMath.HALF_PI, 0, 0);
        mercurio_orbita.attachChild(mercurio_geom);
        padre_cubo.attachChild(mercurio_orbita);
        venus_geom.rotate(-FastMath.HALF_PI, 0, 0);
        venus_orbita.attachChild(venus_geom);
        padre_cubo.attachChild(venus_orbita);
        tierra_geom.rotate(-FastMath.HALF_PI, 0, 0);
        node_tierra.attachChild(tierra_geom);
        luna_geom.rotate(-FastMath.HALF_PI, 0, 0);
        node_tierra.attachChild(luna_geom);
        tierra_orbita.attachChild(node_tierra);
        padre_cubo.attachChild(tierra_orbita);
        marte_geom.rotate(-FastMath.HALF_PI, 0, 0);
        marte_orbita.attachChild(marte_geom);
        padre_cubo.attachChild(marte_orbita);
        jupiter_geom.rotate(-FastMath.HALF_PI, 0, 0);
        jupiter_orbita.attachChild(jupiter_geom);
        padre_cubo.attachChild(jupiter_orbita);
        
        
        //Transformar figuras
        sol_geom.scale(3);
        mercurio_geom.scale(.8f);
        mercurio_geom.move(5, 1, 0);
        venus_geom.scale(0.9f);
        venus_geom.move(10, 1, 0);
        node_tierra.setLocalTranslation(16, 1, 0);
        luna_geom.setLocalTranslation(2, 0, 0);
        luna_geom.scale(0.4f);
        marte_geom.scale(.9f);
        marte_geom.move(23, 1, 0);
        jupiter_geom.scale(1.9f);
        jupiter_geom.move(30, 1, 0);
        
        //Agregar el nodo padre al nodo root
        rootNode.attachChild(padre_cubo);
    }

    @Override
    public void simpleUpdate(float tpf) {
        if (spatial_var == null) {
            sol_spatial = rootNode.getChild("sol_geom");
            mercurio_spatial = rootNode.getChild("mercurio_geom");
            venus_spatial = rootNode.getChild("venus_geom");
            tierra_node = rootNode.getChild("node_tierra");
            tierra_spatial = rootNode.getChild("tierra_geom");
            luna_spatial = rootNode.getChild("luna_geom");
            marte_spatial = rootNode.getChild("marte_geom");
            jupiter_spatial = rootNode.getChild("jupiter_geom");
            
            //Obtenemos las orbitas
            orbita_mercurio = rootNode.getChild("orbita_mercurio");
            orbita_venus = rootNode.getChild("orbita_venus");
            orbita_tierra = rootNode.getChild("orbita_tierra");
            orbita_marte = rootNode.getChild("orbita_marte");
            orbita_jupiter = rootNode.getChild("orbita_jupiter");
        }
        
        //Rotamos los planetas
        sol_spatial.rotate(0, 0, tpf/5);
        mercurio_spatial.rotate(0, 0, tpf*2);
        venus_spatial.rotate(0, 0, tpf*1.5f);
        tierra_node.rotate(0, tpf, 0);
        tierra_spatial.rotate(0, 0, tpf/2);
        luna_spatial.rotate(0, 0, -tpf/4);
        marte_spatial.rotate(0, 0, tpf*.7f);
        jupiter_spatial.rotate(0, 0, tpf*.9f);
        
        //Hacemos girar las orbitas
        orbita_mercurio.rotate(0, tpf*1.9f, 0);
        orbita_venus.rotate(0, tpf*1.3f, 0);
        orbita_tierra.rotate(0, tpf, 0);
        orbita_marte.rotate(0, tpf/2, 0);
        orbita_jupiter.rotate(0, tpf/10, 0);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}