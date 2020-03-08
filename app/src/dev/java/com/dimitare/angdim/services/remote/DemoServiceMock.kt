package com.dimitare.angdim.services.remote

import com.dimitare.angdim.model.ResumeResponse
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import retrofit2.Call
import retrofit2.mock.BehaviorDelegate

class DemoServiceMock internal constructor(val delegate: BehaviorDelegate<DemoServiceApi>) :
    DemoServiceApi {
    val data = "{\n" +
            "    \"code\": 0,\n" +
            "    \"resumeData\": [\n" +
            "        {\n" +
            "            \"id\": \"5e639d5a6a9f800004b61eb4\",\n" +
            "            \"name\": \"Dimitare Karagogov\",\n" +
            "            \"avatar\": \"https://bg-link.herokuapp.com/images/dimitare_profile_picture.jpeg\",\n" +
            "            \"address\": \"aleja 29 Listopada 47B31-482 Kraków\",\n" +
            "            \"phone\": \"+48 792 715 599\",\n" +
            "            \"linkedIn\": \"https://www.linkedin.com/in/karagogov/\",\n" +
            "            \"type\": \"profile\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"categoryName\": \"Professional Summary\",\n" +
            "            \"content\": \"Analytical and detail oriented Android app developer professional with stellar communication skills. Adept at bringing all team members together to reach a common goal on time and under budget. Conceptualizing app solutions with the latest technology, design theory, and a large dose of creativity. Committed to viable and easily functional app solutions for clients.\",\n" +
            "            \"type\": \"professionalSummary\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"categoryName\": \"Topics Of Knowledge\",\n" +
            "            \"categories\": [\n" +
            "                {\n" +
            "                    \"title\": \"Languages\",\n" +
            "                    \"content\": \"Android programming, Windows Mobile, Application programming, Win32, WinCE, MFC, API, STL, COM, Object Oriented Analysis & Design, Windows Multithreading, Socket programming, Thread Models, RenderScript, OpenCL, React Native, MVC, MVP, MVVM\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"title\": \"Software\",\n" +
            "                    \"content\": \"Kotlin, NodeJS, AngularJS, Unity, Windows Mobile 5/6.X, MS-DOS, Windows 9X/NT/2000/XP, Unix, Windows Mobile Architecture.\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"type\": \"topicsOfKnowledge\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"categoryName\": \"Work Experience\",\n" +
            "            \"positions\": [\n" +
            "                {\n" +
            "                    \"jobPosition\": \"SR. ANDROID ENGINEER\",\n" +
            "                    \"companyName\": \"SAVARI\",\n" +
            "                    \"location\": \"SANTA CLARA, CA\",\n" +
            "                    \"duration\": \"August 2018 – current\",\n" +
            "                    \"responsibilities\": [\n" +
            "                        {\n" +
            "                            \"bulletPoint\": \"Designed and implemented SmartCross Application.\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"bulletPoint\": \"Designed and developed home screen and pedestrian and visual details screens.\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"bulletPoint\": \"Used MVVM architecture, databinding, and dagger 2.\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"bulletPoint\": \"Developed GPS location service, Custom GPS location service that utilizes Bluetooth and USB connectivity.\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"bulletPoint\": \"Used AWS to communicate with the backend.\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"bulletPoint\": \"Used device sensor to calculate the device direction.\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"bulletPoint\": \"Used Google Maps to draw components for the user\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"type\": \"workExperience\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"categoryName\": \"Education\",\n" +
            "            \"schools\": [\n" +
            "                {\n" +
            "                    \"schoolName\": \"DePaul University\",\n" +
            "                    \"location\": \"Chicago IL\",\n" +
            "                    \"duration\": \"SEP 2003 – MAR 2007\",\n" +
            "                    \"major\": \"MS (COMPUTER SCIENCE), SOFTWARE ENGINEERING\",\n" +
            "                    \"achievements\": [\n" +
            "                        {\n" +
            "                            \"bulletPoint\": \"GPA 3.5\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"bulletPoint\": \"Writing Handshake protocol in Java, that is part of the SSLSocket, and HTTPS protocol.\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"bulletPoint\": \"Using RMI, and SOAP, and XML. -Advanced Socket Programming\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"bulletPoint\": \"Using JavaCC, Unix, Linux\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"type\": \"education\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"httpStatusCode\": 200\n" +
            "}"

    override fun fetchUserProfile(userId: String): Call<ResumeResponse> {
        val mapper = jacksonObjectMapper()
        val resumeResponse = mapper.readValue(data, ResumeResponse::class.java)
        return delegate.returningResponse(resumeResponse).fetchUserProfile(userId);
    }
}