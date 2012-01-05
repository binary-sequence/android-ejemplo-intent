package ejemploSergio.ejemploActividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActividadPrincipal extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btnUno = (Button) this.findViewById(R.id.btnUno);
		btnUno.setOnClickListener(new BtnUnoClick(this));

		Button btnDatosUno = (Button) this.findViewById(R.id.btnDatosUno);
		btnDatosUno.setOnClickListener(new BtnDatosUnoClick(this));
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);

		Bundle extras = intent.getExtras();

		if (extras != null) {
			switch (requestCode) {
			case 0:
				String datoDos = extras.getString("datoDos");

				TextView tvDatosUno = (TextView) this
						.findViewById(R.id.tvDatosUno);
				tvDatosUno.setText(datoDos);
				break;
			}
		}
	}
}

class BtnUnoClick implements OnClickListener {
	private ActividadPrincipal actividadPrincipal;

	BtnUnoClick(ActividadPrincipal actividadPrincipal) {
		this.actividadPrincipal = actividadPrincipal;
	}

	@Override
	public void onClick(View v) {
		Intent i = new Intent(this.actividadPrincipal, Actividad2.class);
		this.actividadPrincipal.startActivityForResult(i, 0);
	}
}

class BtnDatosUnoClick implements OnClickListener {

	private ActividadPrincipal actividadPrincipal;

	BtnDatosUnoClick(ActividadPrincipal actividadPrincipal) {
		this.actividadPrincipal = actividadPrincipal;
	}

	@Override
	public void onClick(View v) {
		Intent i = new Intent(this.actividadPrincipal, Actividad2.class);

		i.putExtra("datoUno", "hola");

		this.actividadPrincipal.startActivityForResult(i, 0);
	}
}
