package persistence;

import com.evento.entity.Evento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RodrigoCavotre
 */
public interface ConectaDB_Evento {
    void salva(Evento e);
}
