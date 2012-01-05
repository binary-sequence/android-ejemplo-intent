package ejemploSergio.ejemploActividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Actividad2 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actividad2);

		Button btnDos = (Button) this.findViewById(R.id.btnDos);
		btnDos.setOnClickListener(new BtnDosClick(this));

		Button btnDatosDos = (Button) this.findViewById(R.id.btnDatosDos);
		btnDatosDos.setOnClickListener(new BtnDatosDosClick(this));

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String datoUno = extras.getString("datoUno");

			if (datoUno != null) {
				TextView tvDatosDos = (TextView) this
						.findViewById(R.id.tvDatosDos);
				tvDatosDos.setText(datoUno);
			}
		}

	}
}

class BtnDosClick implements OnClickListener {

	private Actividad2 actividad2;

	BtnDosClick(Actividad2 actividad2) {
		this.actividad2 = actividad2;
	}

	@Override
	public void onClick(View v) {
		Intent i = new Intent();
		this.actividad2.setResult(Activity.RESULT_OK, i);
		this.actividad2.finish();
	}
}

class BtnDatosDosClick implements OnClickListener {

	private Actividad2 actividad2;

	BtnDatosDosClick(Actividad2 actividad2) {
		this.actividad2 = actividad2;
	}

	@Override
	public void onClick(View v) {
		Bundle bundle = new Bundle();

		bundle.putString("datoDos", "adios");

		Intent i = new Intent();
		i.putExtras(bundle);
		this.actividad2.setResult(Activity.RESULT_OK, i);
		this.actividad2.finish();
	}
}
