package id.sch.smktelkom_mlg.tugas1.xirpl4005.tugas_formulir;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText etNama;
    EditText etPanggilan;
    EditText etTempat;
    EditText etTanggal;
    EditText etAlamat;
    EditText etHp;

    RadioButton rbL, rbP;
    RadioButton rbM, rbBM;

    CheckBox cbJ, cbVB, cbC, cbH;

    Button bFinish;
    TextView tvN, tvNP, tvRB, tvTK, tvTL, tvRBS, tvA, tvHP, tvHasil, tvJumlah;
    int nJumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etPanggilan = (EditText) findViewById(R.id.editTextPanggilan);
        etTempat = (EditText) findViewById(R.id.editTextTempat);
        etTanggal = (EditText) findViewById(R.id.editTextTanggal);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etHp = (EditText) findViewById(R.id.editTextHp);

        rbL = (RadioButton) findViewById(R.id.radioButtonL);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);
        rbM = (RadioButton) findViewById(R.id.radioButtonM);
        rbBM = (RadioButton) findViewById(R.id.radioButtonBM);

        cbJ = (CheckBox) findViewById(R.id.checkBoxJ);
        cbVB = (CheckBox) findViewById(R.id.checkBoxVB);
        cbC = (CheckBox) findViewById(R.id.checkBoxC);
        cbH = (CheckBox) findViewById(R.id.checkBoxH);

        cbJ.setOnCheckedChangeListener(this);
        cbVB.setOnCheckedChangeListener(this);
        cbC.setOnCheckedChangeListener(this);
        cbH.setOnCheckedChangeListener(this);

        bFinish = (Button) findViewById(R.id.buttonFinish);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvJumlah = (TextView) findViewById(R.id.textViewJumlah);
        tvRB = (TextView) findViewById(R.id.textViewRB);
        tvRBS = (TextView) findViewById(R.id.textViewRBS);
        tvN = (TextView) findViewById(R.id.textViewN);
        tvNP = (TextView) findViewById(R.id.textViewNP);
        tvTK = (TextView) findViewById(R.id.textViewTK);
        tvTL = (TextView) findViewById(R.id.textViewTL);
        tvA = (TextView) findViewById(R.id.textViewA);
        tvHP = (TextView) findViewById(R.id.textViewHP);

        bFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                doClick();
                doCheck();
            }
        });
    }

    private void doCheck() {
        String check = "Bahasa Pemrograman Yang Anda Kuasai : \n ";
        int startlen = check.length();

        if (cbJ.isChecked()) check += cbJ.getText() + "\n";
        if (cbVB.isChecked()) check += cbVB.getText() + "\n";
        if (cbC.isChecked()) check += cbC.getText() + "\n";
        if (cbH.isChecked()) check += cbH.getText() + "\n";

        if (check.length() == startlen) check += "Tidak ada pada pilihan";

        tvHasil.setText(check);
    }

    private void doClick() {
        String hasil1 = null;

        if (rbL.isChecked()) {
            hasil1 = rbL.getText().toString();
        } else if (rbP.isChecked()) {
            hasil1 = rbP.getText().toString();
        }

        if (hasil1 == null) {
            tvRB.setText("Belum Memilih Jenis Kelamin");
        } else {
            tvRB.setText("Jenis Kelamin Calon Pegawai : " + hasil1);
        }

        String hasil2 = null;

        if (rbM.isChecked()) {
            hasil2 = rbM.getText().toString();
        } else if (rbBM.isChecked()) {
            hasil2 = rbBM.getText().toString();
        }

        if (hasil2 == null) {
            tvRBS.setText("Belum Memilih Status");
        } else {
            tvRBS.setText("Status Calon Pegawai : " + hasil2);
        }
    }


    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String panggilan = etPanggilan.getText().toString();
            String tempat = etTempat.getText().toString();
            String tanggal = etTanggal.getText().toString();
            String alamat = etAlamat.getText().toString();
            String hp = etHp.getText().toString();
            tvN.setText("Nama Calon Pegawai : " + nama + "\n");
            tvNP.setText("Nama Panggilan Calon Pegawai : " + panggilan + "\n");
            tvTK.setText("Tempat Lahir Calon Pegawai : " + tempat + "\n");
            tvTL.setText("Tanggal Lahir Calon Pegawai : " + tanggal + "\n");
            tvA.setText("Alamat Calon Pegawai : " + alamat + "\n");
            tvHP.setText("No. Telepon / Hp Calon Pegawai : " + hp + "\n");
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String panggilan = etPanggilan.getText().toString();
        String tempat = etTempat.getText().toString();
        String tanggal = etTanggal.getText().toString();
        String alamat = etAlamat.getText().toString();
        String hp = etHp.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (panggilan.isEmpty()) {
            etPanggilan.setError("Nama panggilan belum diisi");
            valid = false;
        } else {
            etPanggilan.setError(null);
        }

        if (tempat.isEmpty()) {
            etTempat.setError("Tempat lahir belum diisi");
            valid = false;
        } else {
            etTempat.setError(null);
        }

        if (tanggal.isEmpty()) {
            etTanggal.setError("Tanggal lahir belum diisi");
            valid = false;
        } else {
            etTanggal.setError(null);
        }

        if (alamat.isEmpty()) {
            etAlamat.setError("Alamat rumah belum diisi");
            valid = false;
        } else {
            etAlamat.setError(null);
        }

        if (hp.isEmpty()) {
            etHp.setError("No telepon atau Hp belum diisi");
            valid = false;
        } else {
            etHp.setError(null);
        }


        return valid;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) nJumlah += 1;
        else nJumlah -= 1;

        tvJumlah.setText("Bahasa Pemrograman Yang Dikuasai (" + nJumlah + " terpilih)");
    }
}




