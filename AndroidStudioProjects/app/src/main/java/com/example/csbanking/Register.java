package com.example.csbanking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;


import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    private MaterialAlertDialogBuilder materialAlertDialogBuilder;
    private CheckBox checkBox;
    private Button registerBtn;


    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://csbanking-96317-default-rtdb.firebaseio.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        checkBox = findViewById(R.id.check_id);
        registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setEnabled(false);

        materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b) {
                    materialAlertDialogBuilder.setTitle("Data Privacy Act of 2012");
                    materialAlertDialogBuilder.setMessage("[REPUBLIC ACT NO. 10173]\n" +
                            "\n" +
                            "AN ACT PROTECTING INDIVIDUAL PERSONAL INFORMATION IN INFORMATION AND COMMUNICATIONS SYSTEMS IN THE GOVERNMENT AND THE PRIVATE SECTOR, CREATING FOR THIS PURPOSE A NATIONAL PRIVACY COMMISSION, AND FOR OTHER PURPOSES\n" +
                            "\n" +
                            "Be it enacted, by the Senate and House of Representatives of the Philippines in Congress assembled:\n" +
                            "\n" +
                            "CHAPTER I\n" +
                            "GENERAL PROVISIONS\n" +
                            "\n" +
                            "SECTION 1. Short Title. – This Act shall be known as the “Data Privacy Act of 2012”.\n" +
                            "\n" +
                            "SEC. 2. Declaration of Policy. – It is the policy of the State to protect the fundamental human right of privacy, of communication while ensuring free flow of information to promote innovation and growth. The State recognizes the vital role of information and communications technology in nation-building and its inherent obligation to ensure that personal information in information and communications systems in the government and in the private sector are secured and protected.\n" +
                            "\n" +
                            "SEC. 3. Definition of Terms. – Whenever used in this Act, the following terms shall have the respective meanings hereafter set forth:\n" +
                            "\n" +
                            "(a) Commission shall refer to the National Privacy Commission created by virtue of this Act.\n" +
                            "\n" +
                            "(b) Consent of the data subject refers to any freely given, specific, informed indication of will, whereby the data subject agrees to the collection and processing of personal information about and/or relating to him or her. Consent shall be evidenced by written, electronic or recorded means. It may also be given on behalf of the data subject by an agent specifically authorized by the data subject to do so.\n" +
                            "\n" +
                            "(c) Data subject refers to an individual whose personal information is processed.\n" +
                            "\n" +
                            "(d) Direct marketing refers to communication by whatever means of any advertising or marketing material which is directed to particular individuals.\n" +
                            "\n" +
                            "(e) Filing system refers to any act of information relating to natural or juridical persons to the extent that, although the information is not processed by equipment operating automatically in response to instructions given for that purpose, the set is structured, either by reference to individuals or by reference to criteria relating to individuals, in such a way that specific information relating to a particular person is readily accessible.\n" +
                            "\n" +
                            "(f) Information and Communications System refers to a system for generating, sending, receiving, storing or otherwise processing electronic data messages or electronic documents and includes the computer system or other similar device by or which data is recorded, transmitted or stored and any procedure related to the recording, transmission or storage of electronic data, electronic message, or electronic document.\n" +
                            "\n" +
                            "(g) Personal information refers to any information whether recorded in a material form or not, from which the identity of an individual is apparent or can be reasonably and directly ascertained by the entity holding the information, or when put together with other information would directly and certainly identify an individual.\n" +
                            "\n" +
                            "(h) Personal information controller refers to a person or organization who controls the collection, holding, processing or use of personal information, including a person or organization who instructs another person or organization to collect, hold, process, use, transfer or disclose personal information on his or her behalf. The term excludes:\n" +
                            "\n" +
                            "(1) A person or organization who performs such functions as instructed by another person or organization; and\n" +
                            "\n" +
                            "(2) An individual who collects, holds, processes or uses personal information in connection with the individual’s personal, family or household affairs.\n" +
                            "\n" +
                            "(i) Personal information processor refers to any natural or juridical person qualified to act as such under this Act to whom a personal information controller may outsource the processing of personal data pertaining to a data subject.\n" +
                            "\n" +
                            "(j) Processing refers to any operation or any set of operations performed upon personal information including, but not limited to, the collection, recording, organization, storage, updating or modification, retrieval, consultation, use, consolidation, blocking, erasure or destruction of data.\n" +
                            "\n" +
                            "(k) Privileged information refers to any and all forms of data which under the Rules of Court and other pertinent laws constitute privileged communication.\n" +
                            "\n" +
                            "(l) Sensitive personal information refers to personal information:\n" +
                            "\n" +
                            "(1) About an individual’s race, ethnic origin, marital status, age, color, and religious, philosophical or political affiliations;\n" +
                            "\n" +
                            "(2) About an individual’s health, education, genetic or sexual life of a person, or to any proceeding for any offense committed or alleged to have been committed by such person, the disposal of such proceedings, or the sentence of any court in such proceedings;\n" +
                            "\n" +
                            "(3) Issued by government agencies peculiar to an individual which includes, but not limited to, social security numbers, previous or current health records, licenses or its denials, suspension or revocation, and tax returns; and\n" +
                            "\n" +
                            "(4) Specifically established by an executive order or an act of Congress to be kept classified.\n" +
                            "\n" +
                            "SEC. 4. Scope. – This Act applies to the processing of all types of personal information and to any natural and juridical person involved in personal information processing including those personal information controllers and processors who, although not found or established in the Philippines, use equipment that are located in the Philippines, or those who maintain an office, branch or agency in the Philippines subject to the immediately succeeding paragraph: Provided, That the requirements of Section 5 are complied with.\n" +
                            "\n" +
                            "This Act does not apply to the following:\n" +
                            "\n" +
                            "(a) Information about any individual who is or was an officer or employee of a government institution that relates to the position or functions of the individual, including:\n" +
                            "\n" +
                            "(1) The fact that the individual is or was an officer or employee of the government institution;\n" +
                            "\n" +
                            "(2) The title, business address and office telephone number of the individual;\n" +
                            "\n" +
                            "(3) The classification, salary range and responsibilities of the position held by the individual; and\n" +
                            "\n" +
                            "(4) The name of the individual on a document prepared by the individual in the course of employment with the government;\n" +
                            "\n" +
                            "(b) Information about an individual who is or was performing service under contract for a government institution that relates to the services performed, including the terms of the contract, and the name of the individual given in the course of the performance of those services;\n" +
                            "\n" +
                            "(c) Information relating to any discretionary benefit of a financial nature such as the granting of a license or permit given by the government to an individual, including the name of the individual and the exact nature of the benefit;\n" +
                            "\n" +
                            "(d) Personal information processed for journalistic, artistic, literary or research purposes;\n" +
                            "\n" +
                            "(e) Information necessary in order to carry out the functions of public authority which includes the processing of personal data for the performance by the independent, central monetary authority and law enforcement and regulatory agencies of their constitutionally and statutorily mandated functions. Nothing in this Act shall be construed as to have amended or repealed Republic Act No. 1405, otherwise known as the Secrecy of Bank Deposits Act; Republic Act No. 6426, otherwise known as the Foreign Currency Deposit Act; and Republic Act No. 9510, otherwise known as the Credit Information System Act (CISA);\n" +
                            "\n" +
                            "(f) Information necessary for banks and other financial institutions under the jurisdiction of the independent, central monetary authority or Bangko Sentral ng Pilipinas to comply with Republic Act No. 9510, and Republic Act No. 9160, as amended, otherwise known as the Anti-Money Laundering Act and other applicable laws; and\n" +
                            "\n" +
                            "(g) Personal information originally collected from residents of foreign jurisdictions in accordance with the laws of those foreign jurisdictions, including any applicable data privacy laws, which is being processed in the Philippines.\n" +
                            "\n" +
                            "SEC. 5. Protection Afforded to Journalists and Their Sources. – Nothing in this Act shall be construed as to have amended or repealed the provisions of Republic Act No. 53, which affords the publishers, editors or duly accredited reporters of any newspaper, magazine or periodical of general circulation protection from being compelled to reveal the source of any news report or information appearing in said publication which was related in any confidence to such publisher, editor, or reporter.\n" +
                            "\n" +
                            "SEC. 6. Extraterritorial Application. – This Act applies to an act done or practice engaged in and outside of the Philippines by an entity if:\n" +
                            "\n" +
                            "(a) The act, practice or processing relates to personal information about a Philippine citizen or a resident;\n" +
                            "\n" +
                            "(b) The entity has a link with the Philippines, and the entity is processing personal information in the Philippines or even if the processing is outside the Philippines as long as it is about Philippine citizens or residents such as, but not limited to, the following:\n" +
                            "\n" +
                            "(1) A contract is entered in the Philippines;\n" +
                            "\n" +
                            "(2) A juridical entity unincorporated in the Philippines but has central management and control in the country; and\n" +
                            "\n" +
                            "(3) An entity that has a branch, agency, office or subsidiary in the Philippines and the parent or affiliate of the Philippine entity has access to personal information; and\n" +
                            "\n" +
                            "(c) The entity has other links in the Philippines such as, but not limited to:\n" +
                            "\n" +
                            "(1) The entity carries on business in the Philippines; and\n" +
                            "\n" +
                            "(2) The personal information was collected or held by an entity in the Philippines.");

                    materialAlertDialogBuilder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            registerBtn.setEnabled(true);
                            dialog.dismiss();
                        }
                    });
                    materialAlertDialogBuilder.setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            checkBox.setChecked(false);

                        }
                    });
                    materialAlertDialogBuilder.show();
                }else{
                    registerBtn.setEnabled(false);
                }
            }
        });

        final EditText fullname = findViewById(R.id.fullname);
        final EditText email = findViewById(R.id.email);
        final EditText phone = findViewById(R.id.phone);
        final EditText password = findViewById(R.id.password);
        final EditText conPassword = findViewById(R.id.conPassword);

        final Button registerBtn = findViewById(R.id.registerBtn);
        final TextView loginNowBtn = findViewById(R.id.loginNow);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fullnameTxt = fullname.getText().toString();
                final String emailTxt = email.getText().toString();
                final String phoneTxt = phone.getText().toString();
                final String passwordTxt = password.getText().toString();
                final String conPasswordTxt = conPassword.getText().toString();

                if(fullnameTxt.isEmpty() || emailTxt.isEmpty() || phoneTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(Register.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }

                else if(!passwordTxt.equals(conPasswordTxt)){
                    Toast.makeText(Register.this, "Passwords are not matching!", Toast.LENGTH_SHORT).show();
                }

                else{

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if (snapshot.hasChild(phoneTxt)){
                                Toast.makeText(Register.this, "Phone is already registered", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                databaseReference.child("users").child(phoneTxt).child("fullname").setValue(fullnameTxt);
                                databaseReference.child("users").child(phoneTxt).child("email").setValue(emailTxt);
                                databaseReference.child("users").child(phoneTxt).child("password").setValue(passwordTxt);

                                Toast.makeText(Register.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                finish();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });



                }
            }
        });
        loginNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
