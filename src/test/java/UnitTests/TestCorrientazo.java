package UnitTests;

import com.s4n.excepciones.FueraDeLimiteException;
import com.s4n.logica.ControlDron;
import com.s4n.logica.Corrientazo;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestCorrientazo {

    Corrientazo corrientazo;
    ControlDron controlDron;
    private  List<String> movimientos = new ArrayList<>();



    @Before
    public void init(){
        this.corrientazo = new Corrientazo();
        this.controlDron = new ControlDron();
        movimientos.add("AADAIAA");
        this.controlDron.CrearDron(1);
        this.corrientazo.crearDron(1);
    }



    @Test
    public void testCorrientazo() throws IOException, FueraDeLimiteException {
        this.corrientazo.enviarInstrucciones();
        String exito = this.corrientazo.generarReporte();
        assertEquals("reporte escrito correctamente", exito);
    }

    @Test
    public void testControlDron() throws FueraDeLimiteException {
        this.controlDron.moverDron(movimientos);
        String posicionFinal = this.controlDron.traerDron().reportar();
        assertEquals("(1, 4) direccion Norte", posicionFinal);
    }

    @Test(expected = FueraDeLimiteException.class)
    public void testFueraDeLimite() throws FueraDeLimiteException {
        List<String> listaMovimientos = new ArrayList<>();
        listaMovimientos.add("AAAAA");
        listaMovimientos.add("AAAAA");
        listaMovimientos.add("AAAAA");
        this.controlDron.moverDron(listaMovimientos);

    }



}
