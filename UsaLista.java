public class UsaLista{

    public static void main(String[] args){
        ListaDoble lista = new ListaDoble();

        lista.insertaPrimerNodo("H");
        lista.insertaAntesPrimerNodo("O");
        lista.insertaAlFinal("Y");
        lista.insertaEntreNodos("R", "A");
        lista.imprimir();
        System.out.print(lista);
        //Buscar un nodo por su clave y imprimir su referencia
        String valorBuscado = "H";
        Node nodoBuscado = lista.buscarPorClave(valorBuscado);
        if (nodoBuscado != null) {
            System.out.println("Nodo [ " + valorBuscado + " ] encontrado con valor: " + nodoBuscado);
        } else {
            System.out.println("Nodo no encontrado");
        }
        //Insertar un nuevo nodo después de un nodo con un valor específico
        lista.insertarDespues("Y","Z");
        System.out.println("Inserta  Nodo [ Z ] despúes del Nodo [ Y ]");
        lista.imprimir();
        //Intercambiar nodos
        lista.intercambiarNodo("H", "Z");
        System.out.println("Intercambiar Nodo [ H ] por [ Z ]");
        lista.imprimir();
    }

}