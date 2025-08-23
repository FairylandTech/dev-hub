/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 14:57:04 UTC+08:00
 ****************************************************/
package org.example.generics;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author Lionel Johnson
 */
public class StringArrayList implements List<String> {
    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return Collections.emptyList();
    }
    
    @Override
    public int size() {
        return 0;
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    public boolean contains(Object o) {
        return false;
    }
    
    @Override
    public Iterator<String> iterator() {
        return null;
    }
    
    @Override
    public Object[] toArray() {
        return new Object[0];
    }
    
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
    
    @Override
    public boolean add(String s) {
        return false;
    }
    
    @Override
    public boolean remove(Object o) {
        return false;
    }
    
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }
    
    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        return false;
    }
    
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public void clear() {
        
    }
    
    @Override
    public String get(int index) {
        return "";
    }
    
    @Override
    public String set(int index, String element) {
        return "";
    }
    
    @Override
    public void add(int index, String element) {
        
    }
    
    @Override
    public String remove(int index) {
        return "";
    }
    
    @Override
    public int indexOf(Object o) {
        return 0;
    }
    
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
    
    @Override
    public ListIterator<String> listIterator() {
        return null;
    }
    
    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }
    
    @Override
    public void replaceAll(UnaryOperator<String> operator) {
        List.super.replaceAll(operator);
    }
    
    @Override
    public void sort(Comparator<? super String> c) {
        List.super.sort(c);
    }
    
    @Override
    public Spliterator<String> spliterator() {
        return List.super.spliterator();
    }
    
    @Override
    public boolean removeIf(Predicate<? super String> filter) {
        return List.super.removeIf(filter);
    }
    
    @Override
    public Stream<String> stream() {
        return List.super.stream();
    }
    
    @Override
    public Stream<String> parallelStream() {
        return List.super.parallelStream();
    }
    
    @Override
    public void forEach(Consumer<? super String> action) {
        List.super.forEach(action);
    }
}
