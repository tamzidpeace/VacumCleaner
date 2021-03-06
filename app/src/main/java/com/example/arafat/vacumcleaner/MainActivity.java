package com.example.arafat.vacumcleaner;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText selectWorld;
    private TextView status;
    private int dartA = 0, dartB = 0, dartC = 0, dartD = 0;
    private Button worldA, worldB, worldC, worldD, addDart, cleanDart;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectWorld = findViewById(R.id.selected_world);


        worldA = findViewById(R.id.world_a);
        worldB = findViewById(R.id.world_b);
        worldC = findViewById(R.id.world_c);
        worldD = findViewById(R.id.world_d);
        addDart = findViewById(R.id.add_dart_btn);
        cleanDart = findViewById(R.id.clean_dart_btn);

        status = findViewById(R.id.status);

        addDart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String world = selectWorld.getText().toString();

                switch (world) {
                    case "A":
                        worldA.setText(R.string.dart_ID);
                        dartA = 1;
                        break;
                    case "B":
                        worldB.setText(R.string.dart_ID);
                        dartB = 1;
                        break;
                    case "C":
                        worldC.setText(R.string.dart_ID);
                        dartC = 1;
                        break;
                    default:
                        worldD.setText(R.string.dart_ID);
                        dartD = 1;
                        break;
                }
            }
        });

        cleanDart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                status.setText("Cleaning process is running, please wait...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        mHandler = new Handler() {
                            public void handleMessage(Message msg) {
                                System.out.println("hello world");
                            }
                        };


                        // working for world A

                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                status.setText("Checking dirt in World A");
                            }
                        });

                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (dartA == 0) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    status.setText("No dirt found in World A. Moving to World B.");
                                    worldA.setBackgroundResource(R.color.button_color);
                                    worldB.setBackgroundResource(R.drawable.vacum_cleaner);
                                }
                            });
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    status.setText("dart found and has started cleaning");
                                }
                            });

                            try {
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    status.setText("dart has removed. Moving to World B.");
                                    dartA = 0;
                                    worldA.setText("");
                                    worldA.setBackgroundResource(R.color.button_color);
                                    worldB.setBackgroundResource(R.drawable.vacum_cleaner);
                                }
                            });

                        }

                        // working for world B

                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                status.setText("Checking dirt in World B");
                            }
                        });

                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (dartB == 0) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    status.setText("No dirt found in World B. Moving to World B.");
                                    worldB.setBackgroundResource(R.color.button_color);
                                    worldC.setBackgroundResource(R.drawable.vacum_cleaner);
                                }
                            });
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    status.setText("dirt found and has started cleaning");
                                }
                            });

                            try {
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    status.setText("dirt has removed. Moving to World C.");
                                    dartB = 0;
                                    worldB.setText("");
                                    worldB.setBackgroundResource(R.color.button_color);
                                    worldC.setBackgroundResource(R.drawable.vacum_cleaner);
                                }
                            });

                        }

                        // working for world C

                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                status.setText("Checking dirt in World C");
                            }
                        });

                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (dartC == 0) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    status.setText("No dirt found in World C. Moving to World D.");
                                    worldC.setBackgroundResource(R.color.button_color);
                                    worldD.setBackgroundResource(R.drawable.vacum_cleaner);
                                }
                            });
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    status.setText("dirt found and has started cleaning");
                                }
                            });

                            try {
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    status.setText("dirt has removed. Moving to World C.");
                                    dartC = 0;
                                    worldC.setText("");
                                    worldC.setBackgroundResource(R.color.button_color);
                                    worldD.setBackgroundResource(R.drawable.vacum_cleaner);
                                }
                            });

                        }

                        // working for world d

                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                status.setText("Checking dirt in World D");
                            }
                        });

                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (dartD == 0) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    status.setText("No dirt found in World D. All dart has been removed.");
                                    worldD.setBackgroundResource(R.color.button_color);
                                    worldA.setBackgroundResource(R.drawable.vacum_cleaner);
                                }
                            });
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    status.setText("dirt found and has started cleaning");
                                }
                            });

                            try {
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    status.setText("dirt has been removed & All World is clean. Moving to World A.");
                                    dartD = 0;
                                    worldD.setText("");
                                    worldD.setBackgroundResource(R.color.button_color);
                                    worldA.setBackgroundResource(R.drawable.vacum_cleaner);
                                }
                            });

                        }

                        // completed all world

                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                status.setText("Idle");
                            }
                        });
                        Looper.loop();

                    }
                }).start();
            }
        });

    }


}
