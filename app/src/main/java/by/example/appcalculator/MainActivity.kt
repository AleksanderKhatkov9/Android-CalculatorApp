package by.example.appcalculator

import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val MENU_RESET_ID = 1
    val MENU_QUIT_ID = 2


    var etNum1: EditText? = null
    var etNum2: EditText? = null

    var btnAdd: Button? = null
    var btnSub: Button? = null
    var btnMult: Button? = null
    var btnDiv: Button? = null

    var tvResult: TextView? = null

    var oper = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // находим элементы
        etNum1 = findViewById(R.id.etNum1) as EditText
        etNum2 = findViewById(R.id.etNum2) as EditText

        btnAdd = findViewById(R.id.btnAdd) as Button
        btnSub = findViewById(R.id.btnSub) as Button
        btnMult = findViewById(R.id.btnMult) as Button
        btnDiv = findViewById(R.id.btnDiv) as Button

        tvResult = findViewById(R.id.tvResult) as TextView


        // прописываем обработчик

        // прописываем обработчик
        btnAdd!!.setOnClickListener(this)
        btnSub!!.setOnClickListener(this)
        btnMult!!.setOnClickListener(this)
        btnDiv!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        // TODO Auto-generated method stub
        var num1 = 0f
        var num2 = 0f
        var result = 0f

        // Проверяем поля на пустоту

        // Проверяем поля на пустоту
        if (TextUtils.isEmpty(etNum1!!.text.toString())
            || TextUtils.isEmpty(etNum2!!.text.toString())
        ) {
            return
        }


        // читаем EditText и заполняем переменные числами
        num1 = etNum1!!.text.toString().toFloat()
        num2 = etNum2!!.text.toString().toFloat()

        // определяем нажатую кнопку и выполняем соответствующую операцию
        // в oper пишем операцию, потом будем использовать в выводе

        when (v!!.id) {
            R.id.btnAdd -> {
                oper = "+"
                result = num1 + num2
            }
            R.id.btnSub -> {
                oper = "-"
                result = num1 - num2
            }
            R.id.btnMult -> {
                oper = "*"
                result = num1 * num2
            }
            R.id.btnDiv -> {
                oper = "/"
                result = num1 / num2
            }
        }

            // формируем строку вывода
            tvResult!!.text = "$num1 $oper $num2 = $result"
        }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
// TODO Auto-generated method stub
            menu.add(0, MENU_RESET_ID, 0, "Reset")
            menu.add(0, MENU_QUIT_ID, 0, "Quit")
            return super.onCreateOptionsMenu(menu)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
// TODO Auto-generated method stub
            when (item.itemId) {
                MENU_RESET_ID -> {
                    // очищаем поля
                    etNum1!!.setText("")
                    etNum2!!.setText("")
                    tvResult!!.text = ""
                }
                MENU_QUIT_ID -> // выход из приложения
                    finish()
            }
            return super.onOptionsItemSelected(item)
        }
    }