//METODO MAIN (Conjuntos.java):


package conjuntos;
import javax.swing.JOptionPane;
public class Conjuntos {    
    public static void main(String[] args) {
        ClsConjuntos conjuntos = new ClsConjuntos();
        conjuntos.Llenarconjuntos();       
        int RepetirMenu = 0;
        while(RepetirMenu <= 0 || RepetirMenu >4){
             int opc = Integer.parseInt(JOptionPane.showInputDialog("Elige una opción del menú:\n"
            + "1.- MOSTRAR EL CONJUNTO UNIÓN.\n"
            + "2.- MOSTRAR EL CONJUNTO INTERSECCIÓN.\n"
            + "3.- MOSTAR EL CONJUNTO DIFERENCIA DEL PRIMER CONJUNTO.\n"
            + "4.- MOSTRAR EL CONJUNTO DIFERENCIA DEL SEGUNDO CONJUNTO.\n"
            + "5.- LIMPIAR CONJUNTOS Y VOLVER A DAR VALORES.\n"
            + "6.- Salir."));
            switch(opc){
                case 1:
                    conjuntos.Union();
                    RepetirMenu = 0;
                    break;
                case 2:
                    conjuntos.Interseccion();
                    RepetirMenu = 0;
                    break;
                case 3:
                    conjuntos.DiferenciaPrimerConjunto();
                    RepetirMenu = 0;
                    break;
                case 4:
                    conjuntos.DiferenciaSegundoConjunto();
                    RepetirMenu = 0;
                    break;
                case 5:
                    conjuntos.limpiar();
                    JOptionPane.showMessageDialog(null, "CONJUNTO #1 y #2 LIMPIADOS CON ÉXITO!, AHORA DEBERÁ INGRESARLE NUEVOS DATOS...");
                    conjuntos.Llenarconjuntos();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "De nada vuelva pronto...");
                    RepetirMenu = 1;
                    break;
                }
            }  
    }
}

//CLASE DEL LOS CONJUNTOS (ClsConjuntos.java):


package conjuntos;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
public class ClsConjuntos {
    public Set<String>ConjuntoUno=new HashSet();
    public Set<String>ConjuntoDos=new HashSet();
    public void Llenarconjuntos(){
        int RepetirMenuLlenarConjuntos = 0;
        while(RepetirMenuLlenarConjuntos <= 0 || RepetirMenuLlenarConjuntos > 4){
             int opcPrincipal = Integer.parseInt(JOptionPane.showInputDialog("Elige una opción del Pincipal:\n"
            + "1.- INGRESAR DATO AL CONJUNTO #1.\n"
            + "2.- INGRESAR DATO AL CONJUNTO #2.\n"
            + "3.- MOSTRAR LOS HashSet.\n"
            + "4.- MOSTRAR EL SIGUIENTE MENÚ.\n"));
            switch(opcPrincipal){
                case 1:
                    ConjuntoUno.add(JOptionPane.showInputDialog("INGRESA EL ELEMENTO QUE QUIERAS"));
                    JOptionPane.showMessageDialog(null, "CONJUNTO #1:"+"\n"+ConjuntoUno);
                    break;
                case 2:
                    ConjuntoDos.add(JOptionPane.showInputDialog("INGRESA EL ELEMENTO QUE QUIERAS"));
                    JOptionPane.showMessageDialog(null, "CONJUNTO #2:"+"\n"+ConjuntoDos);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "CONJUNTO #1:"+"\n"+ConjuntoUno+"\n"+"\n"+"CONJUNTO #2"+"\n"+ConjuntoDos);
                    break;
                case 4:
                    
                    for(String x: ConjuntoUno){
                        for(String y: ConjuntoDos){
                            if(x.equals("") && y.equals("")){
                                JOptionPane.showMessageDialog(null,"NO PUEDE AVANZAR DEBE DAR DATOS A LOS CONJUNTOS");
                                RepetirMenuLlenarConjuntos = 0;
                            }else{
                                RepetirMenuLlenarConjuntos = 1;
                            }
                        }   
                    }
                    break;
                }
            }
    }
    public void Union(){
        HashSet conjuntoUnion = new HashSet(ConjuntoUno);
        conjuntoUnion.addAll(ConjuntoDos);
        JOptionPane.showMessageDialog(null, "ESTA ES LA UNIÓN DEL CONJUNTO 1 y 2:\n"+"\n"+conjuntoUnion);
    }
    public void Interseccion(){
        HashSet conjuntoInterseccion = new HashSet(ConjuntoUno);
        conjuntoInterseccion.retainAll(ConjuntoDos);
        JOptionPane.showMessageDialog(null, "ESTA ES LA INTERSECCIÓN DEL CONJUNTO 1 y 2:\n"+"\n"+conjuntoInterseccion);
    }
    public void DiferenciaPrimerConjunto(){
        HashSet conjuntoDiferenciaUno = new HashSet(ConjuntoUno);
        conjuntoDiferenciaUno.removeAll(ConjuntoDos);
        JOptionPane.showMessageDialog(null, "ESTA ES LA DIFERENCIA DEL CONJUNTO 1 :\n"+"\n"+conjuntoDiferenciaUno);
    }
    public void DiferenciaSegundoConjunto(){
        HashSet conjuntoDiferenciaDos = new HashSet(ConjuntoDos);
        conjuntoDiferenciaDos.removeAll(ConjuntoUno);
        JOptionPane.showMessageDialog(null, "ESTA ES LA DIFERENCIA DEL CONJUNTO 2 :\n"+"\n"+conjuntoDiferenciaDos);
    }
    public void limpiar(){
        ConjuntoUno.clear();
        ConjuntoDos.clear();
    }
}