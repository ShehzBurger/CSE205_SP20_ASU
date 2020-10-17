// Assignment #: 10
//         Name: Shehzad Anwar
//    StudentID: 1216575295
//  Lab Lecture: TTh 1:30PM
//  Description:
// A linked list is a sequence of nodes with efficient
// element insertion and removal.
// This class contains a subset of the methods of the
// standard java.util.LinkedList class.

import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList
{
    int size = 0;

    //nested class to represent a node
    private class Node
    {
        public Object data;
        public Node next;
    }

    //only instance variable that points to the first node.
    private Node first;

    // Constructs an empty linked list.
    public LinkedList()
    {
        first = null;
    }


    // Returns the first element in the linked list.
    public Object getFirst()
    {
        if (first == null)
        {
            NoSuchElementException ex
                    = new NoSuchElementException();
            throw ex;
        }
        else
            return first.data;
    }

    // Removes the first element in the linked list.
    public Object removeFirst()
    {
        if (first == null)
        {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
        }
        else
        {
            Object element = first.data;
            first = first.next;  //change the reference since it's removed.
            return element;
        }
    }

    // Adds an element to the front of the linked list.
    public void addFirst(Object element)
    {
        //create a new node
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        //change the first reference to the new node.
        first = newNode;
    }

    // Returns an iterator for iterating through this list.
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }


    /*********************************************************
     Add your methods here
     *********************************************************/
    //Displays the output
    public String toString()
    {
        {
            String result = "{ ";
            ListIterator iterator = listIterator();
            while (iterator.hasNext())
            {
                result += iterator.next() + " ";
            }
            result += "}\n";
            return result;
        }
    }

    //returns the number of strings contained within the Linked List
    public int size()
    {
        //initialize values
        ListIterator iterator = listIterator();
        int lSize = 0;

        while(iterator.hasNext())
        {
            iterator.next();
            lSize++;
        }
        return lSize;
    }

    //adds the parameter element into the Linked List
    public void addElement(Object element)
    {
        //initialize values
        ListIterator listIterator = listIterator();
        if (first == null)
        {
            addFirst(element);
        }
        else
        {
            while(listIterator.hasNext())
            {
                Object fruit = listIterator.next();
                if((element.toString()).compareTo((fruit).toString()) < 0)
                {
                    listIterator.set(element);
                    listIterator.add(fruit);
                    return;
                }
            }
            listIterator.add(element);
        }
    }

    //removes and object at even indices within the linked list
    public void removeElementsAtEvenIndices()
    {
        //initialize values
        ListIterator listIterator = listIterator();
        int num = 0;

        while(listIterator.hasNext())
        {
            listIterator.next();
            if( num % 2 == 0 )
            {
                listIterator.remove();
            }
            num++;
        }
    }

    //searches the parameter object in the Linked List, then counts how many elements appear before the first occurrence
    //of the parameter object/element and returns it
    public int howManyAppearBefore(Object element)
    {
        //initialize values
        ListIterator listIterator = listIterator();
        int num = 0;

        while(listIterator.hasNext())
        {
            if(listIterator.next().equals(element))
            {
                return num;
            }
            num++;
        }
        return -1;
    }

    //should look for the last occurrence of the parameter object in the linked list, and return the index of its
    //location.
    public int indexOfLast(Object element)
    {
        //initialize values
        ListIterator listIterator = listIterator();
        int index = 0;
        int lIndex = -1;

        while(listIterator.hasNext())
        {
            if(element.equals(listIterator.next()))
            {
                lIndex = index;
            }
            index++;
        }
        return lIndex;
    }

    //duplicates each element in the linked list
    public void duplicateEach()
    {
        //initialize values
        ListIterator listIterator = listIterator();

        while(listIterator.hasNext())
        {
            listIterator.add(listIterator.next());
        }
    }

    //searches for objects at the parameter index, and it should remove and return the object at the index location
    public Object removeElementAt(int index)
    {
        Object num = null;

        if(index < 0 || index > size() - 1){
            throw new IndexOutOfBoundsException();
        }

        ListIterator listIterator = listIterator();
        int iteratorCounter = 0;

        //Move the iterator to the correct spot
        while(listIterator.hasNext()){
            num = listIterator.next();
            if(iteratorCounter == index){
                break;
            }
            iteratorCounter++;
        }

        listIterator.remove();
        return num;
    }




    //nested class to define its iterator
    private class LinkedListIterator implements ListIterator
    {
        private Node position; //current position
        private Node previous; //it is used for remove() method

        // Constructs an iterator that points to the front
        // of the linked list.

        public LinkedListIterator()
        {
            position = null;
            previous = null;
        }

        // Tests if there is an element after the iterator position.
        public boolean hasNext()
        {
            if (position == null) //not traversed yet
            {
                if (first != null)
                    return true;
                else
                    return false;
            }
            else
            {
                if (position.next != null)
                    return true;
                else
                    return false;
            }
        }

        // Moves the iterator past the next element, and returns
        // the traversed element's data.
        public Object next()
        {
            if (!hasNext())
            {
                NoSuchElementException ex = new NoSuchElementException();
                throw ex;
            }
            else
            {
                previous = position; // Remember for remove

                if (position == null)
                    position = first;
                else
                    position = position.next;

                return position.data;
            }
        }

        // Adds an element after the iterator position
        // and moves the iterator past the inserted element.
        public void add(Object element)
        {
            if (position == null) //never traversed yet
            {
                addFirst(element);
                position = first;
            }
            else
            {
                //making a new node to add
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                //change the link to insert the new node
                position.next = newNode;
                //move the position forward to the new node
                position = newNode;
            }
            //this means that we cannot call remove() right after add()
            previous = position;
        }

        // Removes the last traversed element. This method may
        // only be called after a call to the next() method.
        public void remove()
        {
            if (previous == position)  //not after next() is called
            {
                IllegalStateException ex = new IllegalStateException();
                throw ex;
            }
            else
            {
                if (position == first)
                {
                    removeFirst();
                }
                else
                {
                    previous.next = position.next; //removing
                }
                //stepping back
                //this also means that remove() cannot be called twice in a row.
                position = previous;
            }
        }

        // Sets the last traversed element to a different value.
        public void set(Object element)
        {
            if (position == null)
            {
                NoSuchElementException ex = new NoSuchElementException();
                throw ex;
            }
            else
                position.data = element;
        }
    } //end of LinkedListIterator class
} //end of LinkedList class