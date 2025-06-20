package Ejercicio1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TelefonoSetProxy implements Set<Telefono> {
    private Set<Telefono> telefonos;
    private boolean cargado = false;
    private String personaNombre;

    public TelefonoSetProxy(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    private void cargarTelefonoSiEsNecesario(){
        if(!cargado){
            System.out.println("Cargando telefonos de " + personaNombre);
            telefonos = simularConsultaTelefonosDesdeBD(personaNombre);
            cargado = true;
        }
    }

    private Set<Telefono> simularConsultaTelefonosDesdeBD(String nombre) {
        Set<Telefono> data = new HashSet<>();
        data.add(new Telefono("2984123456"));
        data.add(new Telefono("2984123457"));
        return data;
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
    public Iterator<Telefono> iterator() {
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
    public boolean add(Telefono telefono) {
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
    public boolean addAll(Collection<? extends Telefono> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
