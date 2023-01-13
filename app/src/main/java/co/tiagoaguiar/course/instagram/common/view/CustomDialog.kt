package co.tiagoaguiar.course.instagram.common.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.StringRes
import co.tiagoaguiar.course.instagram.R

class CustomDialog(context: Context) : Dialog(context) {

    private lateinit var dialogLinearLayout: LinearLayout
    private lateinit var txtButtons: Array<TextView>
    private lateinit var txtTitle: TextView

    private var titleId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)

        dialogLinearLayout = findViewById(R.id.dialog_container)
        txtTitle = findViewById(R.id.dialog_title)
    }

    override fun setTitle(titleId: Int) {
        this.titleId = titleId
    }

    fun addButton(@StringRes vararg texts: Int, listener: View.OnClickListener) {
        txtButtons = Array(texts.size) {
            TextView(context)

        }

        texts.forEachIndexed { index, txt ->
            txtButtons[index].id = txt
            txtButtons[index].setText(txt)
            txtButtons[index].setOnClickListener {
                listener.onClick(it)
                dismiss()
            }
        }
    }

    override fun show() {
        super.show()

        titleId?.let {
            txtTitle.setText(it)
        }

        for (txt in txtButtons) {
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(30,40,30,40)
            dialogLinearLayout.addView(txt, layoutParams)
        }
    }

}