public class ListasDobles 
{
    Nodo topForward;
    Nodo topBackward;
    public boolean InsertarPrimerNodo(String dato){
        if (topForward == null) { //La lista está vacía
            topForward = new Nodo();
            topForward.name = dato;
            topForward.previous = null;
            topForward.next = null;
            topBackward = topForward;
            
            return true;
        }
        else {
            return false;
        }
    }
    
    public void Imprimir(){
        System.out.print("[X]");
        for (Nodo temp = this.topForward; temp != null; temp = temp.next){
            System.out.print(" <- [ " + temp.name + " ] -> ");
        }
        System.out.print("[X]\n");
    }
    
    public void BorrarPrimerNodo(){
        this.topForward = this.topForward.next;
        this.topForward.previous.next = null;
        this.topForward.previous = null;
    }
    
    public void BorrarUltimo(){
        this.topBackward = this.topBackward.previous;
        this.topBackward.next.previous = null;
        this.topBackward.next = null;
    }
    
    public void InsertarAntesPrimerNodo(String nombre){
        Nodo temporal;
        temporal = new Nodo ();
        temporal.name = nombre;
        temporal.next = this.topForward;
        this.topForward.previous = temporal;
        this.topForward = temporal;
        temporal = null;
    }
    
    public void InsertaFinal(String nombre){
        Nodo temporal = new Nodo ();
        temporal.name = nombre;
        temporal.next = null;

        temporal.previous = this.topBackward;
        this.topBackward.next = temporal;
        this.topBackward = temporal;
        temporal = null;
    }
    
    public void IntercambiarNodo(String buscado, String nuevo)
    {
        Nodo valorEncontrado = BuscarN(buscado);

        if (valorEncontrado != null)
        {
            Nodo temp2 = topForward;

            while (temp2 != null && !temp2.name.equalsIgnoreCase(buscado))
            {
                temp2 = temp2.next;
            }

            temp2.name = nuevo;
            temp2 = null;
        }
    }
    
    public Nodo BuscarN(String buscado)
    {
        Nodo temp = topForward;

        while (!temp.name.equalsIgnoreCase(buscado))
        {
            temp = temp.next;
        }

        return temp;
    }
    
    public boolean BorrarCualquierNodo(String buscado){
        Nodo temp = this.topForward;

        while ( (temp != null)
                && temp.name.equals(buscado) == false ) {
            temp = temp.next;
        }

        if (temp != null){  //Nodo buscado se encontró
            temp.next = temp.next.next;
            temp.next.previous.previous = null;
            temp.next.previous.next = null;
            temp.next.previous = temp;
            temp = null;

            return true;
        }
        else return false;
    }
    
    public void BuscarYAgregarNodo(String buscado, String nuevoNombre) {
        Nodo encontrado = BuscarN(buscado);

        if (encontrado != null) {

            // Creación del nuevo nodo
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.name = nuevoNombre;

            // Enlace del nuevo nodo
            nuevoNodo.next = encontrado.next;
            if (encontrado.next != null)
            {
                encontrado.next.previous = nuevoNodo;
            }
            encontrado.next = nuevoNodo;

            // Enlace de preview
            nuevoNodo.previous = encontrado;
        }
    }
    
    public String toString()
    {
        String cadAux = "[X]";
        for (Nodo temp = this.topForward; temp != null; temp = temp.next){
            cadAux += " <- [ " + temp.name + " ] -> ";
        }
        cadAux += "[X]\n";

        return cadAux;
    }
}
