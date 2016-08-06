package com.hatenablog.techium.samplerxjavamath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Comparator;

import rx.Observable;
import rx.math.operators.OperatorAverageInteger;
import rx.math.operators.OperatorMinMax;
import rx.math.operators.OperatorSum;
import rx.observables.MathObservable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        minTest();
        maxTest();
        sumTest();
        averageTest();
    }

    private void minTest(){
        Log.d("techium", "---------- minTest ----------");
        OperatorMinMax.min(Observable.just(12, 16, 11, 8))
                .subscribe(value -> {
                    Log.d("techium", "test1 :" + String.valueOf(value));
                });

        // Comparatorを利用
        OperatorMinMax.min(Observable.just(12, 16, 11, 8),
                (o1, o2) -> {
                    Log.d("techium", "test2 : o1: " + o1 + ", o2: " + o2);
                    return o1 - o2;
                })
                .subscribe(value -> {
                    Log.d("techium", "test2 :" + String.valueOf(value));
                });
    }

    private void maxTest(){
        Log.d("techium", "---------- maxTest ----------");
        OperatorMinMax.max(Observable.just(12, 16, 11, 8))
                .subscribe(value -> {
                    Log.d("techium", "test1 :" + String.valueOf(value));
                });

        // Comparatorを利用
        OperatorMinMax.max(Observable.just(12, 16, 11, 8),
                (o1, o2) -> {
                    Log.d("techium", "test2 : o1: " + o1 + ", o2: " + o2);
                    return o1 - o2;
                })
                .subscribe(value -> {
                    Log.d("techium", "test2 :" + String.valueOf(value));
                });
    }

    private void sumTest(){
        Log.d("techium", "---------- sumTest ----------");
        OperatorSum.sumIntegers(Observable.just(12, 16, 11, 8))
                .subscribe(value -> {
                    Log.d("techium", String.valueOf(value));
                });
    }

    private void averageTest(){
        Log.d("techium", "---------- averageTest ----------");
        MathObservable.averageInteger(Observable.just(12, 16, 11, 8))
                .subscribe(value -> {
                    Log.d("techium", String.valueOf(value));
                });
    }
}
