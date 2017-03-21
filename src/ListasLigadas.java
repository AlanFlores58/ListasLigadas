/**
 * Created by alan.flores on 12/20/16.
 */
public class ListasLigadas {

    public static void main(String[] args){
        int i = 0;
        NodeTree root = null;
        Node head = null;
        while (i < 10){
            head = addNode(head,i);
            root = addNodeTree(root,i);
            i++;
        }
        System.out.println("List");
        printLista(head);
        head = rmNode(head, 2);
        System.out.println("Remove index 2");
        head = rmNode(head, 2);
        System.out.println("Remove index 2");
        System.out.println("List");
        printLista(head);
        System.out.println("Tree");
        printTree(root);
        System.out.println("Finish");
    }

    private static class Node{
        Node next;
        int val;
    }

    private static class NodeTree{
        NodeTree izq;
        int val;
        NodeTree der;
    }

    private static NodeTree addNodeTree(NodeTree tree, int value){

        NodeTree newNode = new NodeTree();
        newNode.val = value;
        newNode.der = null;
        newNode.izq = null;

        NodeTree root = tree;
        if (root == null){
            root = newNode;
            System.out.println("Save " + Integer.valueOf(value));
        }else if(root.val >= value){
            System.out.println("Izq");
            root.izq = addNodeTree(root.izq,value);
        }
        else{
            System.out.println("Der");
            root.der = addNodeTree(root.der,value);
        }
        return root;
    }

    private static void printTree(NodeTree root){
        if(root != null){
            printTree(root.izq);
            System.out.println(Integer.valueOf(root.val));
            printTree(root.der);
        }
    }

    private static Node addNode(Node head, int value){

        if (head == null){
            head = new Node();
            head.next = null;
            head.val = value;
            return head;
        }

        Node aux = head;
        while(aux.next != null)
            aux = aux.next;

        Node node = new Node();
        node.next = null;
        node.val  = value;

        aux.next = node;
        return head;
    }

    private static void printLista(Node head){
        Node aux = head;
        while(aux != null) {
            System.out.println(Integer.valueOf(aux.val));
            aux = aux.next;
        }
    }

    private static Node rmNode(Node head, int position){
        Node aux = head;
        int i = 0;
        while (aux != null){
            if(position == i + 1){
                aux.next = aux.next.next;
                break;
            }
            aux = aux.next;
            i++;
        }
        return head;
    }
}
