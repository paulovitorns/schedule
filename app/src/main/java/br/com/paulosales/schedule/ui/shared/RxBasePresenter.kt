package br.com.paulosales.schedule.ui.shared

import br.com.paulosales.schedule.application.SchedulerProvider
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver

abstract class RxBasePresenter<T : BaseUi>(
        private val schedulerProvider: SchedulerProvider
) : BasePresenter<T>() {

    private val subscriptions: CompositeDisposable = CompositeDisposable()

    protected fun <Output> executeFlowable(
            flowable: Flowable<Output>,
            onNext: (Output) -> Unit = {},
            onError: (Throwable) -> Unit = {}
    ) {
        addSubscription(
                flowable.subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribe({
                            onNext(it)
                        }, {
                            onError(it)
                        })
        )
    }

    protected fun <Output> executeSingle(
            single: Single<Output>,
            subscription: DisposableSingleObserver<Output>
    ) {
        single.subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(subscription)
        addSubscription(subscription)
    }

    override fun destroy() {
        super.destroy()
        subscriptions.clear()
    }

    private fun addSubscription(disposable: Disposable) = subscriptions.add(disposable)
}
