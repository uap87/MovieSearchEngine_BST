package project6;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * This class represents a generic BST. It consists of one constructor, four
 * private classes, and a series of methods. BST objects are initially empty.
 * 
 * @author Udit Patel
 * @version 12/5/2018
 *
 * @param <E> generic element that is stored inside the nodes in a BST object
 */
public class BST<E extends Comparable<E>> implements Collection<E>, Iterable<E> {

	private Node<E> root = null;
	private int size;

	/**
	 * Constructs a new BST object
	 */
	public BST() {
	}

	/**
	 * This class represents a generic Node. It consists of two constructors. Each
	 * Node has data inside of it and a reference to its left and right Nodes.
	 * 
	 * @author Udit Patel
	 * @version 12/5/2018
	 */
	private static class Node<E> {
		private E data;
		Node<E> left;
		Node<E> right;

		/**
		 * Constructs a new Node object with element assigned to data and null for left
		 * and right Nodes
		 * 
		 * @param element element that is stored in the Node object
		 */
		Node(E element) {
			this(element, null, null);
		}

		/**
		 * Constructs a new Node object with element assigned to data and left Node
		 * called left and right Node called right
		 * 
		 * @param element element that is stored in the Node object
		 * @param left    left Node that will be referenced from this Node
		 * @param right   right Node that will be referenced from this Node
		 */
		Node(E element, Node<E> left, Node<E> right) {
			this.data = element;
			this.left = left;
			this.right = right;
		}
	}

	/**
	 * This class represents an iterator that traverses through a BST in a preorder
	 * fashion. It contains one constructor, two implemented methods(hasNext() and
	 * next()), and one unimplemented method(remove()).
	 * 
	 * @author Udit Patel
	 * @version 12/5/2018
	 */
	private class PreorderItr implements Iterator<E> {
		// create a new LinkedList object to store the Nodes of the BST
		private LinkedList<Node<E>> list = new LinkedList<Node<E>>();

		/**
		 * Constructs a new preorder iterator using a recursive helper method.
		 */
		PreorderItr() {
			preOrderItr(root);
		}

		/**
		 * Recursive helper method that recursively adds the Nodes of the BST into the
		 * LinkedList in an preorder fashion
		 * 
		 * @param node current Node that represents the root of the tree or subtree that
		 *             is being iterated through
		 */
		private void preOrderItr(Node<E> node) {
			// if current node is null, return
			if (node == null) {
				return;
			}

			// add the current node to the LinkedList
			list.add(node);

			// preorder iterate through the left subtree
			preOrderItr(node.left);

			// preorder iterate through the right subtree
			preOrderItr(node.right);
		}

		/**
		 * Determines whether the iterator has another item to return
		 * 
		 * @return false if empty, true if not
		 */
		@Override
		public boolean hasNext() {
			// if the LinkedList is empty, return false
			if (list.isEmpty()) {
				return false;
			}

			// else, return true
			return true;
		}

		/**
		 * Returns the element in the first Node of the LinkedList and then removes that
		 * Node for the next time next() is called
		 * 
		 * @return the element in the first Node of the LinkedList
		 */
		@Override
		public E next() {
			// if the iterator does not have next, throw a NoSuchElementException
			if (!hasNext()) {
				throw new NoSuchElementException("No element exists");
			}

			// assign the current element to temp
			E temp = list.getFirst().data;

			// remove the first element if LinkedList is not empty so that the next time
			// next() is called, the next element is retrieved through the previous line of
			// code
			if (list.size() >= 1) {
				list.removeFirst();
			}

			// return temp
			return temp;
		}

		/**
		 * The remove operation is not supported by this implementation of
		 * {@code Iterator}.
		 *
		 * @throws UnsupportedOperationException if this method is invoked.
		 * @see java.util.Iterator
		 */
		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * This class represents an iterator that traverses through a BST in an inorder
	 * fashion. It contains one constructor, two implemented methods(hasNext() and
	 * next()), and one unimplemented method(remove()).
	 * 
	 * @author Udit Patel
	 * @version 12/5/2018
	 */
	private class InorderItr implements Iterator<E> {
		// create a new LinkedList object to store the Nodes of the BST
		private LinkedList<Node<E>> list = new LinkedList<Node<E>>();

		/**
		 * Constructs a new inorder iterator using a recursive helper method.
		 */
		InorderItr() {
			inorderItr(root);
		}

		/**
		 * Recursive helper method that recursively adds the Nodes of the BST into the
		 * LinkedList in an inorder fashion
		 * 
		 * @param node current Node that represents the root of the tree or subtree that
		 *             is being iterated through
		 */
		private void inorderItr(Node<E> node) {
			// if current node is null, return
			if (node == null) {
				return;
			}

			// inorder iterate through the left subtree
			inorderItr(node.left);

			// add the current node to the LinkedList
			list.add(node);

			// inorder iterate through the right subtree
			inorderItr(node.right);
		}

		/**
		 * Determines whether the iterator has another item to return
		 * 
		 * @return false if empty, true if not
		 */
		@Override
		public boolean hasNext() {
			// if the LinkedList is empty, return false
			if (list.isEmpty()) {
				return false;
			}

			// else, return true
			return true;
		}

		/**
		 * Returns the element in the first Node of the LinkedList and then removes that
		 * Node for the next time next() is called
		 * 
		 * @return the element in the first Node of the LinkedList
		 */
		@Override
		public E next() {
			// if the iterator does not have next, throw a NoSuchElementException
			if (!hasNext()) {
				throw new NoSuchElementException("No element exists");
			}

			// assign the current element to temp
			E temp = list.getFirst().data;

			// remove the first element if LinkedList is not empty so that the next time
			// next() is called, the next element is retrieved through the previous line of
			// code
			if (list.size() >= 1) {
				list.removeFirst();
			}

			// return temp
			return temp;
		}

		/**
		 * The remove operation is not supported by this implementation of
		 * {@code Iterator}.
		 *
		 * @throws UnsupportedOperationException if this method is invoked.
		 * @see java.util.Iterator
		 */
		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * This class represents an iterator that traverses through a BST in a postorder
	 * fashion. It contains one constructor, two implemented methods(hasNext() and
	 * next()), and one unimplemented method(remove()).
	 * 
	 * @author Udit Patel
	 * @version 12/5/2018
	 */
	private class PostorderItr implements Iterator<E> {
		// create a new LinkedList object to store the Nodes of the BST
		private LinkedList<Node<E>> list = new LinkedList<Node<E>>();

		/**
		 * Constructs a new postorder iterator using a recursive helper method.
		 */
		PostorderItr() {
			postorderItr(root);
		}

		/**
		 * Recursive helper method that recursively adds the Nodes of the BST into the
		 * LinkedList in an postorder fashion
		 * 
		 * @param node current Node that represents the root of the tree or subtree that
		 *             is being iterated through
		 */
		private void postorderItr(Node<E> node) {
			// if current node is null, return
			if (node == null) {
				return;
			}

			// postorder iterate through the left subtree
			postorderItr(node.left);

			// postorder iterate through the right subtree
			postorderItr(node.right);

			// add the current node to the LinkedList
			list.add(node);
		}

		/**
		 * Determines whether the iterator has another item to return
		 * 
		 * @return false if empty, true if not
		 */
		@Override
		public boolean hasNext() {
			// if the LinkedList is empty, return false
			if (list.isEmpty()) {
				return false;
			}

			// else, return true
			return true;
		}

		/**
		 * Returns the element in the first Node of the LinkedList and then removes that
		 * Node for the next time next() is called
		 * 
		 * @return the element in the first Node of the LinkedList
		 */
		@Override
		public E next() {
			// if the iterator does not have next, throw a NoSuchElementException
			if (!hasNext()) {
				throw new NoSuchElementException("No element exists");
			}

			// assign the current element to temp
			E temp = list.getFirst().data;

			// remove the first element if LinkedList is not empty so that the next time
			// next() is called, the next element is retrieved through the previous line of
			// code
			if (list.size() >= 1) {
				list.removeFirst();
			}

			// return temp
			return temp;
		}

		/**
		 * The remove operation is not supported by this implementation of
		 * {@code Iterator}.
		 *
		 * @throws UnsupportedOperationException if this method is invoked.
		 * @see java.util.Iterator
		 */
		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * This method returns the reference to the element stored in the tree with a
	 * value equal to the value passed as the parameter or null if no equal element
	 * exist in this tree. It has a recursive helper method to aid in finding the
	 * requested element.
	 * 
	 * @param value an element to search for in this tree
	 * @return the reference to the element equal to the parameter value or null if
	 *         not such element exists
	 */
	public E get(E value) {
		// if value is null or BST is empty, return null
		if (value == null || isEmpty()) {
			return null;
		}

		// return recursive get method with the value and root of BST
		return get(value, root);
	}

	/**
	 * Recursive method that aids the wrapper method in finding the element
	 * requested within the BST.
	 * 
	 * @param value   an element to search for in this tree
	 * @param current the current Node that is being compared to the value parameter
	 * @return null if current is null; the data of current if it is equal to the
	 *         requested element; a call to the get method depending on how current
	 *         compares to the requested element
	 */
	private E get(E value, Node<E> current) {
		// if current is null, return null
		if (current == null) {
			return null;
		}

		// if current.data is the same as requested element, return that element
		if (current.data.equals(value)) {
			return current.data;
		}

		// if current.data is greater than requested element, call the recursive get
		// method on the left subtree
		else if (current.data.compareTo(value) > 0) {
			return get(value, current.left);
		}

		// else, call the recursive get method on the left subtree
		else {
			return get(value, current.right);
		}
	}

	/**
	 * Returns a string representation of this collection.
	 * 
	 * @return string representation of the BST
	 */
	public String toString() {
		// create new StringBuilder
		StringBuilder stringOfBST = new StringBuilder();

		// create an inorder iterator
		Iterator<E> itr = iterator();

		// append the beginning bracket
		stringOfBST.append("[");

		// for each element, append the string representation of the element followed by
		// a comma and a space
		while (itr.hasNext()) {
			stringOfBST.append(String.valueOf(itr.next()) + ", ");
		}

		// delete the extra comma and space at the end
		stringOfBST.delete(stringOfBST.length() - 2, stringOfBST.length());

		// append the ending bracket
		stringOfBST.append("]");

		// return the string
		return stringOfBST.toString();

	}

	/**
	 * Produces tree like string representation of this BST.
	 * 
	 * @author Joanna Klukowska
	 * @return string containing tree-like representation of this BST
	 */
	public String toStringTreeFormat() {
		StringBuilder s = new StringBuilder();
		preOrderPrint(root, 0, s);
		return s.toString();
	}

	/**
	 * Uses pre-order traversal to produce a tree-like representation of this BST.
	 * 
	 * @author Joanna Klukowska
	 * @param tree   the root of the current subtree
	 * @param level  level (depth) of the current recursive call in the tree to
	 *               determine the indentation of each item
	 * @param output the string that accumulated the string representation of this
	 *               BST
	 */
	private void preOrderPrint(Node<E> tree, int level, StringBuilder output) {
		if (tree != null) {
			String spaces = "\n";
			if (level > 0) {
				for (int i = 0; i < level - 1; i++)
					spaces += " ";
				spaces += "|--";
			}
			output.append(spaces);
			output.append(tree.data);
			preOrderPrint(tree.left, level + 1, output);
			preOrderPrint(tree.right, level + 1, output);
		} else { // print the null children
			String spaces = "\n";
			if (level > 0) {
				for (int i = 0; i < level - 1; i++)
					spaces += " ";
				spaces += "|--";
			}
			output.append(spaces);
			output.append("null");
		}
	}

	/**
	 * Returns an iterator over the elements in this collection. The elements should
	 * be returned in the order determined by the preorder traversal of the tree.
	 * 
	 * @return an preorder iterator of this BST
	 */
	public Iterator<E> preorderIterator() {
		return new PreorderItr();
	}

	/**
	 * Returns an iterator over the elements in this collection. The elements should
	 * be returned in the order determined by the postorder traversal of the tree.
	 * 
	 * @return an postorder iterator of this BST
	 */
	public Iterator<E> postorderIterator() {
		return new PostorderItr();
	}

	/**
	 * Returns the least element in this set greater than or equal to the given
	 * element, or null if there is no such element.
	 * 
	 * @param e the given element that is being used to search through this BST
	 * @return the least element in this set greater than or equal to the given
	 *         element, or null if there is no such element
	 */
	public E ceiling(E e) {
		// if e is null or this BST is empty, return null
		if (e == null || isEmpty()) {
			return null;
		}

		// if this BST contains the given element, return the given element
		if (contains(e)) {
			return e;
		}

		// return a call to the higher method with the given element
		return higher(e);
	}

	/**
	 * Returns a shallow copy of this tree instance.
	 * 
	 * @return shallow copy of this tree instance
	 */
	public Object clone() {
		// create a BST object named clone
		BST<E> clone = new BST<E>();

		// Initialize a preorder iterator
		Iterator<E> itr = preorderIterator();

		// iterate through this BST via iterator and add the elements to the clone BST
		while (itr.hasNext()) {
			clone.add(itr.next());
		}

		// return clone
		return clone;
	}

	/**
	 * Returns the first (lowest) element currently in this set.
	 * 
	 * @return first (lowest) element currently in this set
	 */
	public E first() {
		// if this BST is empty, return null
		if (isEmpty()) {
			return null;
		}

		// create node and assign root to it
		Node<E> current = root;

		// keep going to the left child until null is reached
		while (current.left != null) {
			current = current.left;
		}

		// return the data of the left most Node
		return current.data;
	}

	/**
	 * Returns the greatest element in this set less than or equal to the given
	 * element, or null if there is no such element.
	 * 
	 * @param e the given element that is being used to search through this BST
	 * @return the greatest element in this set less than or equal to the given
	 *         element, or null if there is no such element
	 */
	public E floor(E e) {
		// if e is null or this BST is empty, return null
		if (e == null || isEmpty()) {
			return null;
		}

		// if this BST contains the given element, return the given element
		if (contains(e)) {
			return e;
		}

		// return a call to the lower method with the given element
		return lower(e);
	}

	/**
	 * Returns the least element in this set strictly greater than the given
	 * element, or null if there is no such element.
	 * 
	 * @param e the given element that is being used to search through this BST
	 * @return least element in this set strictly greater than the given element, or
	 *         null if there is no such element.
	 */
	public E higher(E e) {
		// if e is null or this BST is empty, return null
		if (e == null || isEmpty()) {
			return null;
		}

		// if e is higher than or equal to the highest element, return null
		if (e.compareTo(last()) >= 0) {
			return null;
		}

		// return a call to the recursive higher method with the given element, highest
		// element, and root of this BST
		return higher(e, last(), root);
	}

	/**
	 * Recursive helper method that aids the wrapper method above. It helps the
	 * higher method because it traverses down the tree while keeping track of the
	 * least element strictly greater than the given element.
	 * 
	 * @param e                   the given element that is being used to search
	 *                            through this BST
	 * @param lowestElementHigher the least element strictly greater than the given
	 *                            element
	 * @param current             current Node that is being observed
	 * @return a call to the recursive higher method depending on how the current
	 *         Node compares to the other parameters
	 */
	private E higher(E e, E lowestElementHigher, Node<E> current) {
		// if current Node is null, return the current lowestElementHigher parameter
		if (current == null) {
			return lowestElementHigher;
		}

		// else if current.data is greater than the given element, go inside the if
		// statement
		else if ((current.data.compareTo(e) > 0)) {
			// if current.data is less than the current lowestElementHigher parameter,
			// return a call to the recursive higher method with the given element,
			// current.data, and the left child of the current Node
			if (current.data.compareTo(lowestElementHigher) < 0) {
				return higher(e, current.data, current.left);
			}

			// else, return a call to the recursive higher method with the given element,
			// the current lowestElementHigher parameter, and the left child of the current
			// Node
			return higher(e, lowestElementHigher, current.left);
		}

		// else, return a call to the recursive higher method with the given element,
		// the current lowestElementHigher parameter, and the right child of the current
		// Node
		return higher(e, lowestElementHigher, current.right);
	}

	/**
	 * Returns the last (highest) element currently in this set.
	 * 
	 * @return last (highest) element currently in this set
	 */
	public E last() {
		// if this BST is empty, return null
		if (isEmpty()) {
			return null;
		}

		// create node and assign root to it
		Node<E> current = root;

		// keep going to the right child until null is reached
		while (current.right != null) {
			current = current.right;
		}

		// return the data of the right most Node
		return current.data;
	}

	/**
	 * Returns the greatest element in this set strictly less than the given
	 * element, or null if there is no such element.
	 * 
	 * @param e the given element that is being used to search through this BST
	 * @return greatest element in this set strictly less than the given element, or
	 *         null if there is no such element.
	 */
	public E lower(E e) {
		// if e is null or this BST is empty, return null
		if (e == null || isEmpty()) {
			return null;
		}

		// if e is less than or equal to the lowest element in this BST, return null
		if (e.compareTo(first()) <= 0) {
			return null;
		}

		// return a call to the recursive lower method with the given element, lowest
		// element, and the root of this BST
		return lower(e, first(), root);
	}

	/**
	 * Recursive helper method that aids the wrapper method above. It helps the
	 * lower method because it traverses down the tree while keeping track of the
	 * greatest element strictly less than the given element.
	 * 
	 * @param e                   the given element that is being used to search
	 *                            through this BST
	 * @param lowestElementHigher the greatest element strictly less than the given
	 *                            element
	 * @param current             current Node that is being observed
	 * @return a call to the recursive lower method depending on how the current
	 *         Node compares to the other parameters
	 */
	private E lower(E e, E highestElementLower, Node<E> current) {
		// if current Node is null, return the current highestElementLower parameter
		if (current == null) {
			return highestElementLower;
		}

		// else if current.data is less than the given element, go inside the if
		// statement
		else if ((current.data.compareTo(e) < 0)) {
			// if current.data is greater than the current highestElementLower parameter,
			// return a call to the recursive lower method with the given element,
			// current.data, and the right child of the current Node
			if (current.data.compareTo(highestElementLower) > 0) {
				return lower(e, current.data, current.right);
			}

			// else, return a call to the recursive lower method with the given element, the
			// current highestElementLower parameter, and the right child of the current
			// Node
			return lower(e, highestElementLower, current.right);
		}

		// else, return a call to the recursive lower method with the given element,
		// the current highestElementLower parameter, and the left child of the current
		// Node
		return lower(e, highestElementLower, current.left);
	}

	/**
	 * Returns the number of elements in this BST
	 * 
	 * @return the number of elements in this BST
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns true if this BST contains no elements
	 * 
	 * @return true if this BST contains no elements, false if not
	 */
	@Override
	public boolean isEmpty() {
		return root == null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		// if this BST and o are the same BST, return true
		if (this == o) {
			return true;
		}

		// if o is null, return false
		if (o == null) {
			return false;
		}

		// if this BST and o do not have the same class, return false
		if (this.getClass() != o.getClass()) {
			return false;
		}

		// cast o to a BST named temp
		BST<?> temp = (BST<?>) o;

		// if temp and this BST do not have the same size, return false
		if (temp.size() != size()) {
			return false;
		}

		// return true if this BST contains all of the elements in temp; return false if
		// not
		return containsAll(temp);
	}

	/**
	 * Returns true if this BST contains the specified element.
	 * 
	 * @param o Object that is being tested whether it is in this BST
	 * @return true if this BST contains the specified element, false if not
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) {
		// if o is null or this BST is empty, return false
		if (o == null || isEmpty()) {
			return false;
		}

		// if the elements in this BST and o are not of the same class, return false
		if (root.data.getClass() != o.getClass()) {
			return false;
		}

		// if a call to the get method with this element returns null, return false
		if (get((E) o) == null) {
			return false;
		}

		// else, return true
		return true;
	}

	/**
	 * Returns an iterator over the elements in this collection. The elements should
	 * be returned in the order determined by the inorder traversal of the tree.
	 * 
	 * @return an inorder iterator of this BST
	 */
	@Override
	public Iterator<E> iterator() {
		return new InorderItr();
	}

	/**
	 * Returns an array containing all of the elements in this collection.
	 * 
	 * @return array containing all of the elements in this collection
	 */
	@Override
	public Object[] toArray() {
		// create an array of Object types with the size of this list
		Object[] arr = new Object[size()];

		// initialize counter named i and an inorder iterator
		Iterator<E> itr = iterator();
		int i = 0;

		// iterate through this list and assign the values to array arr
		while (itr.hasNext()) {
			arr[i++] = itr.next();
		}

		// return the new array arr with the elements from this list
		return arr;
	}

	/**
	 * Returns an array containing all of the elements in this collection; the
	 * runtime type of the returned array is that of the specified array.
	 * 
	 * @param a array indicating the type desired and also where this BST's elements
	 *          should be copied to
	 * @return array containing all of the elements in this collection of type
	 *         requested in specified array
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		// if the specified array is too small, create a new instance of an array
		// of T type objects with the size of this list and assign it to array a
		if (a.length < size()) {
			// following line taken from java.util source
			a = (T[]) Array.newInstance(a.getClass().getComponentType(), size());
		}

		// initialize counter named i and an inorder iterator
		Iterator<E> itr = iterator();
		int i = 0;

		// iterate through this list and assign the values to array a
		while (itr.hasNext()) {
			a[i++] = (T) itr.next();
		}

		// return the new array a with the elements from this list
		return a;
	}

	/**
	 * Adds the element to this BST unless the element is not valid or a duplicate
	 * of an element already present in this BST.
	 * 
	 * @param e element to be added
	 * @return true if element is added, false if not
	 */
	@Override
	public boolean add(E e) {
		// if e is null, return false
		if (e == null) {
			return false;
		}

		// try adding the element, and return false if an IllegalArgumentException is
		// caught
		try {
			root = add(e, root);
		} catch (IllegalArgumentException ex) {
			return false;
		}

		// increase size by 1
		size++;

		// return true
		return true;
	}

	/**
	 * Recursive method that aids the wrapper method above. It helps add by
	 * traversing down the tree to find where the element needs to be added.
	 * 
	 * @param e       element to be added
	 * @param current current Node that is being observed
	 * @return a new Node with the element to be added as its data
	 * @throws IllegalArgumentException if the element to be added already exists in
	 *                                  this BST
	 */
	private Node<E> add(E e, Node<E> current) throws IllegalArgumentException {
		// if current is null, create a new Node using this element and return that node
		if (current == null) {
			return new Node<E>(e);
		}

		// if element to be added is equal to current.data, throw
		// IllegalArgumentException because this is a duplicate
		if (e.equals(current.data)) {
			throw new IllegalArgumentException("Duplicate Value");
		}

		// if element to be added is less than current.data, call the recursive add
		// method with the element to be added and the left child of the current Node
		else if (e.compareTo(current.data) < 0) {
			current.left = add(e, current.left);
		}

		// if element to be added is greater than current.data, call the recursive add
		// method with the element to be added and the right child of the current Node
		else if (e.compareTo(current.data) > 0) {
			current.right = add(e, current.right);
		}

		// return current Node
		return current;
	}

	/**
	 * Removes a single instance of the specified element from this collection, if
	 * it is present. The remove method is partly based off of the in class
	 * discussion on removing a Node from a BST.
	 * 
	 * @param o object to be removed
	 * @return true if object has been removed successfully, false if not
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		// if o is null or this BST is empty, return false
		if (o == null || isEmpty()) {
			return false;
		}

		// if this BST does not contain o, return false
		if (!contains(o)) {
			return false;
		}

		// if the class of the elements in this BST and the class of o are not equal,
		// return false
		if (root.data.getClass() != o.getClass()) {
			return false;
		}

		// call the recursive remove method on o casted to type E and the root of this
		// BST
		remove((E) o, root);

		// decrease the size by 1 after removing o
		size--;

		// return true
		return true;
	}

	/**
	 * Recursive method that aids the wrapper method above. It helps remove by
	 * traversing down the tree to find where the element that needs to be removed
	 * is.
	 * 
	 * @param o       object to be removed
	 * @param current current Node that is being observed
	 * @return call to recursive remove method depending on how the current node
	 *         compares to the element being removed
	 */
	private Node<E> remove(E e, Node<E> current) {
		// if current.data is larger than e, then make the left child of the current
		// Node equal to a call on the recursive remove method with e and the left child
		// of the current Node
		if (current.data.compareTo(e) > 0) {
			current.left = remove(e, current.left);
		}

		// else if current.data is smaller than e, then make the right child of the
		// current Node equal to a call on the recursive remove method with e and the
		// right child of the current Node
		else if (current.data.compareTo(e) < 0) {
			current.right = remove(e, current.right);
		}

		// else, current.data is equal to e, so enter the else statement
		else {
			// if current.left is null, return current.right; takes care of no children and
			// one child cases
			if (current.left == null) {
				return current.right;
			}

			// else if current.right is null, return current.left; takes care of one child
			// case
			else if (current.right == null) {
				return current.left;
			}

			// else, make current.data equal to the greatest element in the left child's
			// subtree and then remove the greatest element from the left child's subtree
			else {
				current.data = removeLast(current.left);
				current.left = remove(current.data, current.left);
			}
		}

		// return current
		return current;
	}

	/**
	 * Helper method that is similar to the last() method but has the ability to
	 * perform the operations of last() on a subtree because of the Node parameter.
	 * It is named removeLast for recognition purposes because it is only used in
	 * the remove method.
	 * 
	 * @param root root of the subtree that the maximum element is being searched
	 *             for
	 * @return the maximum element of the subtree which has the root parameter as
	 *         its root
	 */
	private E removeLast(Node<E> current) {
		// keep going to the right child until null is reached
		while (current.right != null) {
			current = current.right;
		}

		// return the data of the right most Node
		return current.data;
	}

	/**
	 * Returns true if this collection contains all of the elements in the specified
	 * collection
	 * 
	 * @param c collection that is being compared to this list
	 * @return true if this collection contains all of the elements in the specified
	 *         collection, false if not
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		// iterate through c and if any of the elements in c are not contained in this
		// BST, return false
		for (Object o : c) {
			if (!contains(o)) {
				return false;
			}
		}

		// return true
		return true;
	}

	/**
	 * The addAll operation is not supported by this implementation of
	 * {@code Collection}.
	 *
	 * @throws UnsupportedOperationException if this method is invoked.
	 * @see java.util.Collection
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * The removeAll operation is not supported by this implementation of
	 * {@code Collection}.
	 *
	 * @throws UnsupportedOperationException if this method is invoked.
	 * @see java.util.Collection
	 */
	@Override
	public boolean removeAll(Collection<?> c) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * The retainAll operation is not supported by this implementation of
	 * {@code Collection}.
	 *
	 * @throws UnsupportedOperationException if this method is invoked.
	 * @see java.util.Collection
	 */
	@Override
	public boolean retainAll(Collection<?> c) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * The hashCode operation is not supported by this implementation of
	 * {@code Collection}.
	 *
	 * @throws UnsupportedOperationException if this method is invoked.
	 * @see java.util.Collection
	 */
	public int hashCode() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes all of the elements from this collection.
	 */
	@Override
	public void clear() {
		// make root equal to null, therefore clearing this BST
		root = null;

		// make size equal to 0, because there are no elements in this BST anymore
		size = 0;
	}
}