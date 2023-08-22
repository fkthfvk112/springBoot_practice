import axios from "axios";
import React from "react"
import { useState } from "react"

export default function Tts(){
    const [text, setText]  = useState();
    const submitBtn = (evt)=>{
        let data = {
            speech:text
        }
        let params = {params:{
            speech:text
        }};
        
        //disabled전략
        axios.post('http://localhost:3000/tts', data)
            .then((res)=>{
                console.log(res.data);
            })
            
        // axios.post('http://localhost:3000/tts', null, params)
        // .then((res)=>{
        //     console.log(res.data);
        // })
    }
    return (
        <div>
            <textarea onChange={(e)=>{setText(e.target.value)}} value={text} placeholder="음성으로 바꿀 텍스트" name="text" id="" cols="30" rows="10"></textarea>
            <button type="button" onClick={submitBtn}>제출</button>
        </div>
        )
}