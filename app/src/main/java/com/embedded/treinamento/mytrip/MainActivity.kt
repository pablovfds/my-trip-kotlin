package com.embedded.treinamento.mytrip

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View) {
        if (view.id == R.id.btnCalculate) {
            hundleCalculate()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(this)
    }

    private fun hundleCalculate() {
        if (isValid()) {
            try {

                val distance = edtDistance.text.toString().toFloat()
                val price = edtPrice.text.toString().toFloat()
                val autonomy = edtAutonomy.text.toString().toFloat()

                val result = ((distance * price)/autonomy)
                tvResult.setText("Total: R$ $result")

            } catch (nfe: NumberFormatException){
                Toast.makeText(this, getString(R.string.msg_error_valid_values), Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, getString(R.string.msg_error_valid_values), Toast.LENGTH_LONG).show()
        }
    }

    private fun isValid(): Boolean {
        return edtDistance.text.toString() != ""
                && edtPrice.text.toString() != ""
                && edtAutonomy.text.toString() != ""
                && edtAutonomy.text.toString() != "0"
    }
}
