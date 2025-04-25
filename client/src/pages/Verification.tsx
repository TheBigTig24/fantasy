import NavBar from "../components/navbar";
import React, { useState, useEffect, useRef } from 'react';
import '../styles/verification.css';
import { useNavigate } from "react-router-dom";

const Verification = () => {

    const navigate = useNavigate();

    const [boxes, setBoxes] = useState<(string | null)[]>(Array(6).fill(""));
    const inputRefs = useRef<(HTMLInputElement | null)[]>([])
    const [isComplete, setIsComplete] = useState<boolean>(false);

    const [userId, setUserId] = useState<string | null>("");
    const [email, setEmail] = useState<string | null>("");

    useEffect(() => {
        if (inputRefs.current[0]) {
          inputRefs.current[0].focus();
        }
        
        setUserId(localStorage.getItem('userId'));

        try {
            const uri = "http://localhost:8080/api/v1/users/emailOnly?id=" + localStorage.getItem('userId');
            fetch(uri, {
                method: 'GET',
                mode: 'cors',
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then((res) => {
                if (res.status == 200) {
                    return res.json();
                } else {
                    console.error("Couldn't retrieve userId");
                }
            }).then((res) => {
                setEmail(res.email);
            }).catch((error) => {
                console.error(error);
            });
        } catch (e) {
            console.error(e);
        }

    }, []);

    const handleTyping = (e: React.ChangeEvent<HTMLInputElement>, index: number) => {
        const value: string = e.target.value;
        const newBoxes: (string | null)[] = [...boxes];
        newBoxes[index] = value;
        setBoxes(newBoxes);

        if (value && index < 5) {
            inputRefs.current[index + 1]?.focus();
        } else {
            setIsComplete(true);
        }
    };

    const handleBackspace = (e: React.KeyboardEvent, index: number) => {
        if (e.key === "Backspace") {
            const newBoxes = [...boxes];

            if (boxes[index]) {
                newBoxes[index] = "";
                setBoxes(newBoxes);
            } else if (index > 0) {
                newBoxes[index - 1] = "";
                setBoxes(newBoxes);
                inputRefs.current[index - 1]?.focus();
            }
        }
    };

    useEffect(() => {
        if (isComplete) {
            const verify: string = boxes.join("");

            try {
                const uri: string = "http://localhost:8080/api/v1/auth/verify";
                const reqJson = {"email": email, "verificationCode": verify};

                fetch(uri, {
                    method: 'POST',
                    mode: 'cors',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(reqJson)
                }).then((res) => {
                    if (res.status == 200) {
                        return res.json();
                    } else {
                        console.error("Couldn't verify account.");
                    }
                }).then((res) => {
                    alert("Your account has been successfully verified!");
                    navigate('/login');
                })
            } catch (e) {
                console.error(e);
            }
        }
    }, [isComplete]);

    const resendEmail = () => {
        try {
            const splitEmail: string[] | undefined = email?.split("@");
            if (!splitEmail) {
                console.error("No email present.");
                return;
            }
            const formatEmail: string = splitEmail[0] + "%40" + splitEmail[1];
            const uri: string = "http://localhost:8080/api/v1/auth/resend?email=" + formatEmail;
            console.log(uri);
            fetch(uri, {
                method: 'POST',
                mode: 'cors'
            }).then((res) => {
                if (res.status == 200) {
                    return res.json();
                } else {
                    console.error("Couldn't resend email.");
                }
            }).then((res) => {
                alert(`Email has been resent to ${email}`);
            })
        } catch (e) {
            console.error(e);
        }
    };

    return (<>
        <NavBar />
        <div id="verification-container">
            <div id="verification-box">
                <h1>Enter Verification Code</h1>
                <p>Enter code sent to email.</p>
                <p id="resend-email">Click<a onClick={resendEmail}> here </a>to resend email.</p>
                <div id="input-verification">
                    {boxes.map((_, index) => {
                        return <input
                            key={index}
                            ref={(el) => (inputRefs.current[index] = el)}
                            type="text"
                            inputMode="numeric"
                            maxLength={1}
                            className="char-box"
                            onChange={(e) => handleTyping(e, index)}
                            onKeyDown={(e) => handleBackspace(e, index)}
                        ></input>
                    })}
                </div>
                <button id="verify-btn">Verify</button>
            </div>
        </div>
    </>)
};

export default Verification;