/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Empleado;

/**
 *
 * @author daw1
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupOrdenListado = new javax.swing.ButtonGroup();
        selectorFicheros = new javax.swing.JFileChooser();
        panelDatosEmpleado = new javax.swing.JPanel();
        labelDni = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        labelSalario = new javax.swing.JLabel();
        textDni = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox<>();
        textSalario = new javax.swing.JTextField();
        labelIngresos = new javax.swing.JLabel();
        textIngresos = new javax.swing.JTextField();
        buttonBorrar = new javax.swing.JButton();
        buttonModificar = new javax.swing.JButton();
        labelHoras = new javax.swing.JLabel();
        spinnerHoras = new javax.swing.JSpinner();
        panelListado = new javax.swing.JPanel();
        buttonListarEmpleados = new javax.swing.JButton();
        labelOrdenListasdo = new javax.swing.JLabel();
        scrollTabla = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        radioDni = new javax.swing.JRadioButton();
        radioNombre = new javax.swing.JRadioButton();
        radioIngresos = new javax.swing.JRadioButton();
        menuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        miAbrir = new javax.swing.JMenuItem();
        miGuardar = new javax.swing.JMenuItem();
        menuEmpleado = new javax.swing.JMenu();
        miNuevo = new javax.swing.JMenuItem();
        miBuscar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de n??minas");

        panelDatosEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del empleado"));
        panelDatosEmpleado.setName(""); // NOI18N

        labelDni.setText("DNI");

        labelNombre.setText("NOMBRE");

        labelTipo.setText("TIPO");

        labelSalario.setText("SALARIO");

        textDni.setEditable(false);
        textDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDniActionPerformed(evt);
            }
        });

        textNombre.setEditable(false);

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIJO", "EVENTUAL" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        textSalario.setEditable(false);

        labelIngresos.setText("INGRESOS");

        textIngresos.setEditable(false);

        buttonBorrar.setText("BORRAR");
        buttonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBorrarActionPerformed(evt);
            }
        });

        buttonModificar.setText("MODIFICAR");
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        labelHoras.setText("HORAS");

        javax.swing.GroupLayout panelDatosEmpleadoLayout = new javax.swing.GroupLayout(panelDatosEmpleado);
        panelDatosEmpleado.setLayout(panelDatosEmpleadoLayout);
        panelDatosEmpleadoLayout.setHorizontalGroup(
            panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosEmpleadoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosEmpleadoLayout.createSequentialGroup()
                        .addComponent(labelIngresos)
                        .addGap(18, 18, 18)
                        .addComponent(textIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosEmpleadoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(buttonBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(buttonModificar)
                        .addGap(22, 22, 22)))
                .addContainerGap())
            .addGroup(panelDatosEmpleadoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDni)
                    .addComponent(labelNombre)
                    .addComponent(labelTipo)
                    .addComponent(labelSalario)
                    .addComponent(labelHoras))
                .addGap(22, 22, 22)
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textDni)
                        .addComponent(textNombre)
                        .addComponent(textSalario, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(comboTipo, 0, 204, Short.MAX_VALUE))
                    .addComponent(spinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosEmpleadoLayout.setVerticalGroup(
            panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosEmpleadoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDni)
                    .addComponent(textDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTipo)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSalario)
                    .addComponent(textSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHoras)
                    .addComponent(spinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIngresos)
                    .addComponent(textIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonModificar)
                    .addComponent(buttonBorrar))
                .addGap(22, 22, 22))
        );

        labelHoras.setVisible(false);
        spinnerHoras.setVisible(false);

        panelListado.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de empleados"));

        buttonListarEmpleados.setText("LISTAR EMPLEADOS");
        buttonListarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListarEmpleadosActionPerformed(evt);
            }
        });

        labelOrdenListasdo.setText("ORDEN DEL LISTADO");

        // Para que se muestre en la tabla;
        tablaEmpleados.setModel(empleadoTM);
        tablaEmpleados.setToolTipText("");

        tablaEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrollTabla.setViewportView(tablaEmpleados);
        // Para que la informaci??n de la tabla se cargue en en los datos a la izquierda;
        tablaEmpleados.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent lse){
                int fila=tablaEmpleados.getSelectedRow();
                if(fila>=0){
                    textDni.setText((String)tablaEmpleados.getValueAt(fila, 0));
                    textNombre.setText((String)tablaEmpleados.getValueAt(fila, 1));
                    textSalario.setText(Float.toString((Float)tablaEmpleados.getValueAt(fila, 2)));
                    if((int)(tablaEmpleados.getValueAt(fila, 3))==0){
                        comboTipo.setSelectedItem("FIJO");
                    }
                    else{
                        comboTipo.setSelectedItem("EVENTUAL");
                        spinnerHoras.setValue(tablaEmpleados.getValueAt(fila, 3));
                    }
                    textIngresos.setText(Float.toString((Float)tablaEmpleados.getValueAt(fila, 4)));
                }
            }
        });

        groupOrdenListado.add(radioDni);
        radioDni.setSelected(true);
        radioDni.setText("DNI");
        radioDni.setName(""); // NOI18N

        groupOrdenListado.add(radioNombre);
        radioNombre.setText("NOMBRE");

        groupOrdenListado.add(radioIngresos);
        radioIngresos.setText("INGRESOS");

        javax.swing.GroupLayout panelListadoLayout = new javax.swing.GroupLayout(panelListado);
        panelListado.setLayout(panelListadoLayout);
        panelListadoLayout.setHorizontalGroup(
            panelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListadoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelOrdenListasdo)
                .addGap(28, 28, 28)
                .addComponent(radioDni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioIngresos)
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonListarEmpleados)
                .addGap(193, 193, 193))
        );
        panelListadoLayout.setVerticalGroup(
            panelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListadoLayout.createSequentialGroup()
                .addComponent(buttonListarEmpleados)
                .addGap(8, 8, 8)
                .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOrdenListasdo)
                    .addComponent(radioDni)
                    .addComponent(radioNombre)
                    .addComponent(radioIngresos))
                .addGap(14, 14, 14))
        );

        menuArchivo.setText("Archivo");

        miAbrir.setText("Abrir...");
        miAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(miAbrir);

        miGuardar.setText("Guardar...");
        miGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGuardarActionPerformed(evt);
            }
        });
        menuArchivo.add(miGuardar);

        menuBar.add(menuArchivo);

        menuEmpleado.setText("Empleado");

        miNuevo.setText("Nuevo");
        miNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNuevoActionPerformed(evt);
            }
        });
        menuEmpleado.add(miNuevo);

        miBuscar.setText("Buscar...");
        miBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBuscarActionPerformed(evt);
            }
        });
        menuEmpleado.add(miBuscar);

        menuBar.add(menuEmpleado);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDatosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNuevoActionPerformed
        if(dialogoEmpleado.mostrar()==DialogoEmpleado.ACEPTAR){
            try{
                textDni.setText(dialogoEmpleado.getDni());
                textNombre.setText(dialogoEmpleado.getNombre());
                comboTipo.setSelectedItem(dialogoEmpleado.getTipo());
                textSalario.setText(Float.toString(dialogoEmpleado.getSalario()));
                if(dialogoEmpleado.getHoras()>0){
                    spinnerHoras.setValue(dialogoEmpleado.getHoras());
                    textIngresos.setText(Float.toString(dialogoEmpleado.getSalario()*dialogoEmpleado.getHoras()));
                }
                else{
                    textIngresos.setText(Float.toString(dialogoEmpleado.getSalario()));
                }
                controlador.crearEmpleado();
            } catch (NumberFormatException nfe){
                limpiarCampos();
                mostrarMensaje("Error en n??mero");
            } catch (IllegalArgumentException iae){
                limpiarCampos();
                mostrarMensaje(iae.getLocalizedMessage());
            }
        }
    }//GEN-LAST:event_miNuevoActionPerformed

    private void buttonListarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListarEmpleadosActionPerformed
        controlador.listarEmpleados();
        empleadoTM.fireTableDataChanged();
        tablaEmpleados.revalidate();
        limpiarCampos();
    }//GEN-LAST:event_buttonListarEmpleadosActionPerformed

    private void miAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAbrirActionPerformed
        if(selectorFicheros.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            controlador.cargarEmpleados();
        }
    }//GEN-LAST:event_miAbrirActionPerformed

    private void miGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGuardarActionPerformed
        if(selectorFicheros.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
            controlador.guardarEmpleados();
        }
    }//GEN-LAST:event_miGuardarActionPerformed

    private void buttonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBorrarActionPerformed
        if(solicitarConfirmacion()){
            controlador.eliminarEmpleado();
            limpiarCampos();
        }
        tablaEmpleados.revalidate();
    }//GEN-LAST:event_buttonBorrarActionPerformed

    private void miBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarActionPerformed
        controlador.buscarEmpleado();
    }//GEN-LAST:event_miBuscarActionPerformed

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        controlador.modificarEmpleado();
    }//GEN-LAST:event_buttonModificarActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        if(getTipo().equals("FIJO")){
            spinnerHoras.setVisible(false);
            labelHoras.setVisible(false);
        }
        if(getTipo().equals("EVENTUAL")){
            spinnerHoras.setVisible(true);
            labelHoras.setVisible(true);
        }
    }//GEN-LAST:event_comboTipoActionPerformed

    private void textDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDniActionPerformed
    
    public String getTipo(){
        return (String)comboTipo.getSelectedItem();
    }
    public String getDni(){
        return textDni.getText();
    }
    public String getNombre(){
        return textNombre.getText();
    }
    public float getSalario(){
        return Float.parseFloat(textSalario.getText());
    }
    public int getHoras(){
        return (int) spinnerHoras.getValue();
    }
    public String getArchivo(){
        return selectorFicheros.getSelectedFile().getAbsolutePath();
    }
    public String getOrden(){
        String orden=null;
        if(radioDni.isSelected()){
            orden=radioDni.getText();
        }
        if(radioNombre.isSelected()){
            orden=radioNombre.getText();
        }
        if(radioIngresos.isSelected()){
            orden=radioIngresos.getText();
        }
        return orden;
    }
    
    public void mostrarTipo(String tipo){
        comboTipo.setSelectedItem(tipo);
    }
    public void mostrarDni(String dni){
        textDni.setText(dni);
    }
    public void mostrarNombre(String nombre){
        textNombre.setText(nombre);
    }
    public void mostrarSalario(float salario){
        textSalario.setText(Float.toString(salario));
    }
    public void mostrarHoras(int horas){
        spinnerHoras.setValue(horas);
    }
    public void mostrarIngresos(float ingresos){
        textIngresos.setText(Float.toString(ingresos));
    }
    
    public void listarEmpleados(List<Empleado> listado){
        empleadoTM.setListado(listado);
        tablaEmpleados.revalidate();
    }
    
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }
    
    public boolean solicitarConfirmacion(){
        if(JOptionPane.showConfirmDialog(this, "??Est??s seguro de Borrar? Ser?? permanente")==JOptionPane.OK_OPTION){
            return true;
        }
        return false;
    }
    
    public void limpiarCampos(){
        textDni.setText("");
        textNombre.setText("");
        textSalario.setText("");
        textIngresos.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    
    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }
    
    public void mostrar(){
        setVisible(true);
    }
    
    private Controlador controlador;
    private DialogoEmpleado dialogoEmpleado=new DialogoEmpleado(this, true);
    private EmpleadoTableModel empleadoTM=new EmpleadoTableModel();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBorrar;
    private javax.swing.JButton buttonListarEmpleados;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.ButtonGroup groupOrdenListado;
    private javax.swing.JLabel labelDni;
    private javax.swing.JLabel labelHoras;
    private javax.swing.JLabel labelIngresos;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelOrdenListasdo;
    private javax.swing.JLabel labelSalario;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEmpleado;
    private javax.swing.JMenuItem miAbrir;
    private javax.swing.JMenuItem miBuscar;
    private javax.swing.JMenuItem miGuardar;
    private javax.swing.JMenuItem miNuevo;
    private javax.swing.JPanel panelDatosEmpleado;
    private javax.swing.JPanel panelListado;
    private javax.swing.JRadioButton radioDni;
    private javax.swing.JRadioButton radioIngresos;
    private javax.swing.JRadioButton radioNombre;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JFileChooser selectorFicheros;
    private javax.swing.JSpinner spinnerHoras;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField textDni;
    private javax.swing.JTextField textIngresos;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textSalario;
    // End of variables declaration//GEN-END:variables
}
