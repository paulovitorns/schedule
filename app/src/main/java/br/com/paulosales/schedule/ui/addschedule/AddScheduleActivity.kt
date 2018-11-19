package br.com.paulosales.schedule.ui.addschedule

import android.os.Bundle
import br.com.paulosales.schedule.R
import br.com.paulosales.schedule.ui.shared.BaseView

class AddScheduleActivity : BaseView<AddSchedulePresenter>(), AddScheduleUi {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_schedule)

        setTitle("Add Schedule", true)
    }
}
