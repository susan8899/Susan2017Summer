package com.example.susancarrera.susan2017summer;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.preference.DialogPreference;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.susancarrera.susan2017summer.dialog.CustomDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends BaseActivity {

    private final int DIALOG = 12345;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DIALOG:
                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    shortToast("Dialog Message: " + s);
                    break;
                default:
            }
            super.handleMessage(msg);
        }
    };


        private int checkedID = 0;

        @BindView(R.id.activity_dialog_rdg)
        RadioGroup radioGroup;

        @OnClick(R.id.activity_dialog_ok)
        public void ok(View v) {
            switch (checkedID) {

                case R.id.activity_dialog_rb1:
                    normalDialog();
                    break;
                case R.id.activity_dialog_rb2:
                    listDialog();
                    break;
                case R.id.activity_dialog_rb3:
                    singleChoiceDialog();
                    break;
                case R.id.activity_dialog_rb4:
                    multiChoiceDialog();
                    break;
                case R.id.activity_dialog_rb5:
                    waitingDialog();
                    break;
                case R.id.activity_dialog_rb6:
                    progressDialog();
                    break;
                case R.id.activity_dialog_rb7:
                    inputDialog();
                    break;
                case R.id.activity_dialog_rb8:

                    CustomDialog customDialog =
                            new CustomDialog(this, new CustomDialog.ICustomDialogListener() {
                                @Override
                                public void onOKClicked(String msg) {
                                    showToast(msg);
                                }
                            });
                    customDialog.setCanceledOnTouchOutside(true);
                    customDialog.show();

                    break;
                default:
            }

        }


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dialog);
            ButterKnife.bind(this);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    checkedID = checkedId;
                    shortToast("you chose: " + checkedId);


                }
            });
        }


        //can only add at most 3 buttons
        private void normalDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle("AlertTitle");
            builder.setMessage("This is a normal Dialog");

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    shortToast("You clicked Yes");
                }
            });

            builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    shortToast("You clicked Neutral");
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    shortToast("You clicked Cancel");
                }
            });


            builder.show();

        }

        ProgressDialog waitingDialog;

        private void waitingDialog() {
            waitingDialog = new ProgressDialog(this);
            waitingDialog.setTitle("Downloading");
            waitingDialog.setMessage("Waiting...");
//            waitingDialog.setCancelable(false);
            waitingDialog.setCancelable(true);
            waitingDialog.show();
            waitingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

                public void onDismiss(DialogInterface dialog) {
                    shortToast("Dialog was canceled!");
                    //stop the download thread
                }
            });
        }

        ArrayList<Integer> choices = new ArrayList<>();

        private void multiChoiceDialog() {
            final String[] items = {"item1", "item2", "item3", "item4"};
            final boolean initChoiceSets[] = {false, false, false, false};
            choices.clear();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("I am a multi-choice Dialog");
            builder.setMultiChoiceItems(items, initChoiceSets,
                    new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which,
                                            boolean isChecked) {
                            if (isChecked) {
                                choices.add(which);
                            } else {
                                choices.remove(which);
                            }
                        }
                    });
            builder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int size = choices.size();
                            String str = " ";
                            for (int i = 0; i < size; i++) {
                                str += items[choices.get(i)] + " ";
                            }
                            shortToast("You chose: " + str);
                        }
                    });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    shortToast("Cancel was clicked");
                }
            });
            builder.show();
        }

        int choice = 2;

        private void singleChoiceDialog() {
            final String[] items = {"item0", "item1", "item2", "item3"};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("I'm a Single Choice Dialog");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    choice = which;
                }
            });
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    shortToast("You clicked: " + choice);
                }
            });
            builder.show();
        }

        private void listDialog() {
            final String[] items = {"item1", "item2", "item3", "item4"};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("I'm a List Dialog");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    shortToast("You clicked: " + items[which]);
                }
            });
            builder.show();
        }


        private void progressDialog() {
            final int MAX_PROGRESS = 100;
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setProgress(0);
            progressDialog.setTitle("Downloading");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMax(MAX_PROGRESS);
            progressDialog.show();


            /*New Thread, Every 100ms, progress + 1*/

            new Thread(new Runnable() {
                @Override
                public void run() {
                    int progress = 0;
                    while (progress < MAX_PROGRESS) {
                        try {
                            Thread.sleep(100);
                            progress++;
                            progressDialog.setProgress(progress);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

//                    shortToast("Downloading success");
                    Bundle bundle = new Bundle();
                    bundle.putString("msg", "Download success");
                    Message msg = Message.obtain();
                    msg.what = DIALOG;
                    msg.setData(bundle);
                    mHandler.sendMessage(msg);

                    /*when toasting here you are updating the UI thread,
                     but you are in a new thread so your application
                     will crash
                     have to use a handler to send a msg out*/

//                    shortToast("Download finished");  this will cause error: WindowLeaked
                    progressDialog.cancel();

                }

            }).start();
        }

        private void inputDialog() {
            final EditText editText = new EditText(this);
            AlertDialog.Builder inputDialog = new AlertDialog.Builder(this);
            inputDialog.setTitle("I'm an input Dialog").setView(editText);
            inputDialog.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            shortToast(editText.getText().toString());
                        }
                    });
            inputDialog.setNegativeButton("Cancel", null).show();
        }
    }




