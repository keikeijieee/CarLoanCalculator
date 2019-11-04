package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateRepayment()
        }
    }

    private fun calculateRepayment() {
        //TODO get inputs and show outputs
        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error_input))
            return
        }
        if(editTextDownPayment.text.isEmpty()){
            editTextDownPayment.setError(getString(R.string.error_input))
            return
        }
        if(editTextInterestRate.text.isEmpty()){
            editTextInterestRate.setError(getString(R.string.error_input))
            return
        }
        if(editTextLoanPeriod.text.isEmpty()){
            editTextLoanPeriod.setError(getString(R.string.error_input))
            return
        }
        
        val carPrice: Int = editTextCarPrice.text.toString().toInt(); //convert to integer
        val downPayment: Int = editTextDownPayment.text.toString().toInt();
        val loan = carPrice - downPayment
        val loanPeriod: Int =  editTextLoanPeriod.text.toString().toInt()
        val interest: Float = editTextInterestRate.text.toString().toFloat() * carPrice * loanPeriod
        val monthlyRepayment: Float = (carPrice + interest) / loanPeriod / 12


        textViewLoan.setText(getString(R.string.loan) + "${loan}")
        textViewInterest.setText(getString(R.string.interest) + "${interest}")
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + "${monthlyRepayment}")
    }

    fun reset(view: View){
        editTextLoanPeriod.setText("")
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextInterestRate.setText("")
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment))
        textViewInterest.setText(getString(R.string.interest))
        textViewLoan.setText(getString(R.string.loan))
    }
}
