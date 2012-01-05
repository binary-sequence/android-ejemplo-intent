package ejemploSergio.ejemploActividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

//Clase que se ejecuta desde ActividadPrincipal.
public class Actividad2 extends Activity {
	/** Constructores y métodos heredados a partir de aquí */

	// Método ejecutado cuando al inicio.
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// La GUI de esta actividad está definida en actividad2.xml
		setContentView(R.layout.actividad2);

		// Obtengo el elemento btnDos definido en actividad2.xml
		Button btnDos = (Button) this.findViewById(R.id.btnDos);

		// Asigno al elemento btnDos un evento click de clase BtnDosClick.
		btnDos.setOnClickListener(new BtnDosClick(this));

		// Obtengo el elemento btnDatosDos definido en actividad2.xml
		Button btnDatosDos = (Button) this.findViewById(R.id.btnDatosDos);

		// Asigno al elemento btnDatosDos un evento click de clase
		// BtnDatosDosClick.
		btnDatosDos.setOnClickListener(new BtnDatosDosClick(this));

		// Obtengo los datos recibidos de ActividadPrincipal.
		Bundle extras = getIntent().getExtras();

		// Si se han recibido datos.
		if (extras != null) {
			// Obtengo el valor del dato con nombre datoUno.
			String datoUno = extras.getString("datoUno");

			// Obtengo el elemento tvDatosUno definido en actividad2.xml
			TextView tvDatosDos = (TextView) this.findViewById(R.id.tvDatosDos);

			// Asigno el dato al elemento tvDatosDos.
			tvDatosDos.setText(datoUno);
		}

	}
}

// Clase que gestiona el evento click del elemento btnDos.
class BtnDosClick implements OnClickListener {
	/** Propiedades a partir de aquí */

	// Referencia a la actividad para acceder a sus datos.
	private Actividad2 actividad2;

	/** Constructores y métodos heredados a partir de aquí */

	// El constructor se encarga de pedir la referencia a la actividad.
	BtnDosClick(Actividad2 actividad2) {
		this.actividad2 = actividad2;
	}

	// Método ejecutado en el evento click del elemento btnDos.
	@Override
	public void onClick(View v) {
		// Para volver a la actividad principal se necesita un Intent.
		Intent i = new Intent();

		// Indica que se ha ejecutado la actividad correctamente.
		this.actividad2.setResult(Activity.RESULT_OK, i);

		// Finaliza la acticidad2.
		this.actividad2.finish();
	}
}

// Clase que gestiona el evento click del elemento btnDatosDos.
class BtnDatosDosClick implements OnClickListener {
	/** Propiedades a partir de aquí */

	// Referencia a la actividad para acceder a sus datos.
	private Actividad2 actividad2;

	/** Constructores y métodos heredados a partir de aquí */

	// El constructor se encarga de pedir la referencia a la actividad.
	BtnDatosDosClick(Actividad2 actividad2) {
		this.actividad2 = actividad2;
	}

	// Método ejecutado en el evento click del elemento btnDos.
	@Override
	public void onClick(View v) {
		// Para devolver datos a la actividad principal se necesita un objeto
		// Bundle.
		Bundle bundle = new Bundle();

		// Devuelvo una cadena de texto (adios) bajo el nombre datoDos.
		bundle.putString("datoDos", "adios");

		// Para volver a la actividad principal se necesita un Intent.
		Intent i = new Intent();

		// Agrego el objeto Bundle al intent.
		i.putExtras(bundle);

		// Indica que se ha ejecutado la actividad correctamente.
		this.actividad2.setResult(Activity.RESULT_OK, i);

		// Finaliza la acticidad2.
		this.actividad2.finish();
	}
}
