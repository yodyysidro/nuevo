/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerc2;

import java.util.Objects;
public class Hotel implements Comparable<Hotel>{
    //Atributos.
    private int idHotel;
    private String zona;  //Playa, montaña o rural.
    private int precio;
    public Hotel (int idHotel, String zona, int precio) {
        this.idHotel=idHotel;
        this.zona=zona;
        this.precio=precio;
    }

    @Override
    public String toString () {return "Hotel -> ID: "+idHotel+" Zona: "+zona+" Precio: "+precio; }

    @Override
    public int compareTo (Hotel o) {return this.precio-o.precio;}

    @Override
    public int hashCode() {return idHotel+zona.hashCode()+precio;}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {return false;}
        if (getClass()!=obj.getClass()) {return false;}
        final Hotel other = (Hotel) obj;
        if (this.idHotel!=other.idHotel) {return false;}
        if (!Objects.equals(this.zona, other.zona)) {return false;}
        if (this.precio != other.precio) {return false;}
        return true;
    }
}