/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class Pedido {
    private int idPedido;
    private int qtdeMedicamento;
    private String dia;
    
    private Cliente idCliente;
    private Cliente telefone;
    private Medicamento idMedicamento;
    
    
    public int getQtdeMedicamento() {
        return qtdeMedicamento;
    }

    public void setQtdeMedicamento(int qtdeMedicamento) {
        this.qtdeMedicamento = qtdeMedicamento;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Medicamento getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Medicamento idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    public Cliente gettelefone() {
        return telefone;
    }

    public void settelefone(Cliente telefone) {
        this.telefone = telefone;
    }
    
}
