package com.panelaquente.panelaquente.Factory;

public interface DtoFactory<E, T> {

     public E createEntityFrom(T dto);

    public T createDTOFrom(E product);
}
