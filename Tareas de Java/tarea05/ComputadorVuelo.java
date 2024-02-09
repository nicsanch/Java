package tarea05;
/**
 * Clase que representa el <b>computador de vuelo</b> que se interconecta con los sistemas de vuelo de ultraligeros con motor para gestionar las diferentes operaciones de escuelas de vuelo.
<br>
<br>Los objetos de esta clase permiten almacenar y gestionar la información relativa al estado de la aeronave y la información de vuelo.
<br>
<ul>
<li><b>cantidad total de aeronaves</b> que existen en la escuela</li>
<li><b>cantidad de aeronaves volando</b> en el momento actual</li>
<li><b>cantidad total </b> de horas de vuelo de todas las aeronaves</li>
</ul>
<br>
 * @author Nicolás Sánchez Pérez
 * @version 1.0
 */
public class ComputadorVuelo {
    // Atributos de instancia (estado inmutable)
    /** Matricula unica de la aeronave. */
    private final String MATRICULA;
    /** Modelo de la aeronave. */
    private final String MODELO;

    // Atributos de estado de la aeronave
    private boolean volando;
    private String nombrePiloto;
    private int tipoVuelo;
    private int tiempoTotalVuelo;
    private String mensajeEstado;

    // Atributos de informacion de vuelo
    private int velocidad;
    private int rumbo;
    private int altitud;

    // Atributos estaticos
    private static int cantidadTotalAeronaves = 0;
    private static int cantidadAeronavesVolando = 0;
    private static float totalHorasVuelo = 0;

    // Atributos constantes
    /** Nombre del piloto por defecto. */
    public static final String PILOTO_DEFECTO = "Juan Perez";
    /** Matricula por defecto. */
    public static final String MATRICULA_DEFECTO = "EC-ABC";
    /** Modelo por defecto. */
    public static final String MODELO_DEFECTO = "Cessna 152";
    /** Altitud minima de vuelo. */
    public static final int MIN_ALTITUD = 1000;
    /** Altitud maxima de vuelo. */
    public static final int MAX_ALTITUD = 3000;
    /** Tipo de vuelo: Escuela. */
    public static final int VUELO_ESCUELA = 0;
    /** Tipo de vuelo: Privado. */
    public static final int VUELO_PRIVADO = 1;

    /**
     * Metodo que devuelve una cadena que representa el estado del Computador de Vuelo en un momento dado.
     *
     * @return Cadena que representa el estado del Computador de Vuelo.
     */
    @Override
    public String toString() {
        return String.format("[Matricula=%s, Modelo=%s, isVolando=%b, Piloto=%s, TipoVuelo=%d, TiempoTotal=%d, V=%d km/h, Rumbo=%dº, Altitud=%d metros]",
                getMatricula(), getModelo(), isVolando(), getPiloto(), getTipoVuelo(), getTiempoTotalVuelo(),
                getVelocidad(), getRumbo(), getAltitud());
    }

    /**
     * Constructor de la clase ComputadorVuelo con tres parametros.
     *
     * @param matricula Matricula unica de la aeronave.
     * @param modelo    Modelo de la aeronave.
     * @param piloto    Nombre del piloto.
     */
    public ComputadorVuelo(String matricula, String modelo, String piloto) {
        validarParametros(matricula, modelo, piloto);
        this.MATRICULA = matricula;
        this.MODELO = modelo;
        this.nombrePiloto = piloto;
        cantidadTotalAeronaves++;
    }

    /**
     * Constructor de la clase ComputadorVuelo con dos parametros.
     *
     * @param matricula Matricula unica de la aeronave.
     * @param modelo    Modelo de la aeronave.
     */
    public ComputadorVuelo(String matricula, String modelo) {
        this(matricula, modelo, PILOTO_DEFECTO);
        cantidadTotalAeronaves++;
    }

    /**
     * Constructor de la clase ComputadorVuelo sin parametros.
     */
    public ComputadorVuelo() {
        this(MATRICULA_DEFECTO, MODELO_DEFECTO, PILOTO_DEFECTO);
        cantidadTotalAeronaves++;
    }

    /**
     * Metodo de fabrica para crear un array de ComputadorVuelo.
     *
     * @param cantidad Cantidad de aeronaves a crear.
     * @return Array de ComputadorVuelo.
     * @throws IllegalArgumentException Si la cantidad es incorrecta.
     */
    public static ComputadorVuelo[] crearArrayComputadorVuelo(int cantidad) {
        if (cantidad < 1 || cantidad > 10) {
            throw new IllegalArgumentException("Numero de aviones incorrecto " + cantidad +
                    ", debe ser mayor o igual que 1 y menor o igual que 10");
        }
        ComputadorVuelo[] arrayAeronaves = new ComputadorVuelo[cantidad];
        for (int i = 0; i < cantidad; i++) {
            arrayAeronaves[i] = new ComputadorVuelo();
            cantidadTotalAeronaves++;
        }
        return arrayAeronaves;
    }

    /**
     * Metodo que devuelve la matricula de la aeronave.
     *
     * @return Matricula de la aeronave.
     */
    public String getMatricula() {
        return (MATRICULA != null) ? MATRICULA : MATRICULA_DEFECTO;
    }

    /**
     * Metodo que devuelve el modelo de la aeronave.
     *
     * @return Modelo de la aeronave.
     */
    public String getModelo() {
        return (MODELO != null) ? MODELO : MODELO_DEFECTO;
    }

    /**
     * Metodo que devuelve si la aeronave esta volando.
     *
     * @return true si la aeronave esta volando, false si no.
     */
    public boolean isVolando() {
        return volando;
    }

    /**
     * Metodo que devuelve el nombre del piloto.
     *
     * @return Nombre del piloto.
     */
    public String getPiloto() {
        return (nombrePiloto != null) ? nombrePiloto : PILOTO_DEFECTO;
    }

    /**
     * Metodo que devuelve el tipo de vuelo.
     *
     * @return Tipo de vuelo (VUELO_ESCUELA o VUELO_PRIVADO).
     */
    public int getTipoVuelo() {
        return (tipoVuelo != 0) ? tipoVuelo : VUELO_ESCUELA;
    }

    /**
     * Metodo que devuelve el tiempo total de vuelo.
     *
     * @return Tiempo total de vuelo en minutos.
     */
    public int getTiempoTotalVuelo() {
        return tiempoTotalVuelo;
    }

    /**
     * Metodo que devuelve la velocidad de la aeronave.
     *
     * @return Velocidad de la aeronave en km/h.
     */
    public int getVelocidad() {
        return (volando) ? velocidad : 0;
    }

    /**
     * Metodo que devuelve el rumbo de la aeronave.
     *
     * @return Rumbo de la aeronave en grados.
     */
    public int getRumbo() {
        return (volando) ? rumbo : 0;
    }

    /**
     * Metodo que devuelve la altitud de la aeronave.
     *
     * @return Altitud de la aeronave en metros.
     */
    public int getAltitud() {
        return (volando) ? altitud : 0;
    }

    /**
     * Metodo de modificacion que establece la velocidad de la aeronave.
     *
     * @param nuevaVelocidad Nueva velocidad de la aeronave en km/h.
     */
    public void setVelocidad(int nuevaVelocidad) {
        if (volando) {
            velocidad = nuevaVelocidad;
        }
    }

    /**
     * Metodo de modificacion que establece el rumbo de la aeronave.
     *
     * @param nuevoRumbo Nuevo rumbo de la aeronave en grados.
     */
    public void setRumbo(int nuevoRumbo) {
        if (volando) {
            rumbo = nuevoRumbo;
        }
    }

    /**
     * Metodo de modificacion que establece la altitud de la aeronave.
     *
     * @param nuevaAltitud Nueva altitud de la aeronave en metros.
     */
    public void setAltitud(int nuevaAltitud) {
        if (volando) {
            altitud = Math.max(MIN_ALTITUD, Math.min(nuevaAltitud, MAX_ALTITUD));
        }
    }

    /**
     * Metodo estatico que devuelve la cantidad total de aeronaves creadas.
     *
     * @return Cantidad total de aeronaves.
     */
    public static int getNumAeronaves() {
        return cantidadTotalAeronaves;
    }

    /**
     * Metodo estatico que devuelve la cantidad de aeronaves actualmente volando.
     *
     * @return Cantidad de aeronaves volando.
     */
    public static int getNumAeronavesVolando() {
        return cantidadAeronavesVolando;
    }

    /**
     * Metodo estatico que devuelve el numero total de horas de vuelo de todas las aeronaves.
     *
     * @return Numero total de horas de vuelo en horas.
     */
    public static float getNumHorasVuelo() {
        return (totalHorasVuelo / 60);
    }

    /**
     * Metodo privado para validar parametros en los constructores.
     *
     * @param matricula Matricula de la aeronave.
     * @param modelo    Modelo de la aeronave.
     * @param piloto    Nombre del piloto.
     * @throws NullPointerException     Si matricula, modelo o piloto son nulos.
     * @throws IllegalArgumentException Si la matricula es una cadena vacia o tiene un formato incorrecto.
     */ 
    private void validarParametros(String matricula, String modelo, String piloto) {
        if (matricula == null) {
            throw new NullPointerException("La matricula de la aeronave no puede ser nula");
        }
        if (modelo == null) {
            throw new NullPointerException("El modelo de la aeronave no puede ser nulo");
        }
        if (piloto == null) {
            throw new NullPointerException("El piloto de la aeronave no puede ser nulo");
        }
        if (matricula.isEmpty()) {
            throw new IllegalArgumentException("La matricula es una cadena vacia");
        }
        if (!matricula.matches("EC-[A-Z0-9]{3}")) {
            throw new IllegalArgumentException("El formato de la matricula es incorrecto: " + matricula);
        }
    }
    
    /**
     * Metodo para despegar la aeronave.
     *
     * @param tipoVuelo Tipo de vuelo (VUELO_ESCUELA o VUELO_PRIVADO).
     * @param velocidad Velocidad inicial de la aeronave.
     * @param altitud   Altitud de vuelo inicial.
     * @throws IllegalArgumentException Si la altitud de vuelo es incorrecta.
     * @throws IllegalStateException    Si la aeronave ya ha despegado o se alcanzo el limite de aeronaves volando.
     */
    public void despegar(int tipoVuelo, int velocidad, int altitud) {
    if (altitud < MIN_ALTITUD || altitud > MAX_ALTITUD) {
        throw new IllegalArgumentException("La altitud de vuelo de " + altitud + " metros es incorrecta");
    }


    if (this.volando == true) {
        throw new IllegalStateException(this.MATRICULA + " ya ha despegado y se encuentra fuera del aeropuerto");
    }

    // Verificar si hay espacio para mas aeronaves volando
    if (cantidadAeronavesVolando >= 10) {
        throw new IllegalStateException("No se puede despegar mas aeronaves, el limite de aeronaves volando ha sido alcanzado");
    }

    // Configurar los atributos de vuelo
    this.tipoVuelo = tipoVuelo;
    this.velocidad = velocidad;
    this.altitud = altitud;
    this.rumbo = 0; // Puedes establecer un rumbo predeterminado si es necesario

    // Actualizar los contadores estaticos
    cantidadAeronavesVolando++;

    // Cambiar el estado de la aeronave a volando
    this.volando = true;

    // Mostrar mensaje de despegue
    mensajeEstado = ("Aeronave con matricula " + this.MATRICULA + " ha despegado con exito.");
}

    /**
     * Metodo para aterrizar la aeronave.
     *
     * @throws IllegalStateException Si la aeronave ya ha aterrizado o no ha despegado.
     */
    public void aterrizar() {
        if (this.volando == false) {
        throw new IllegalStateException(this.MATRICULA + " ya ha aterrizado y debe despegar de nuevo antes de volver a aterrizar");
        }

        // Actualizar los contadores estaticos y estado de la aeronave
        cantidadAeronavesVolando--;
        this.volando = false;
        mensajeEstado = ("Aeronave con matricula " + this.MATRICULA + " ha aterrizado con exito.");
    }
    
    
    /**
     * Metodo para aterrizar la aeronave en un aeropuerto especifico.
     *
     * @param aeropuertoSalida  Aeropuerto de salida.
     * @param aeropuertoLlegada Aeropuerto de llegada.
     * @param tiempoVuelo       Tiempo total de vuelo en minutos.
     * @throws IllegalStateException Si la aeronave ya ha aterrizado o no ha despegado.
     */    
    public void aterrizar(String aeropuertoSalida, String aeropuertoLlegada, int tiempoVuelo) {
    if (this.volando == false) {
        throw new IllegalStateException(this.MATRICULA + " ya ha aterrizado y debe despegar de nuevo antes de volver a aterrizar");
    }

    // Actualizar el tiempo de vuelo total
    this.tiempoTotalVuelo += tiempoVuelo;
    totalHorasVuelo += tiempoVuelo; // Convertir minutos a horas

    // Actualizar el estado de vuelo
    this.volando = false;

    // Actualizar los contadores estaticos
    cantidadAeronavesVolando--;

    // Mostrar mensaje de aterrizaje
    mensajeEstado = ("Aeronave con matricula " + this.MATRICULA + " ha aterrizado en " + aeropuertoLlegada + " proveniente de " + aeropuertoSalida +
            ". Tiempo de vuelo: " + tiempoVuelo + " minutos.");

}

}

