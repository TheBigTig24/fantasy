import NavBar from "../components/navbar";
import { useState, useEffect } from 'react'
import '../styles/schedule.css'

import UpcomingMatch from "../components/upcomingMatch";


const Schedule = () => {

    const [stuff, setStuff] = useState([])
    const [LCKid, setLCKid] = useState()

    // sets LCK League Id
    useEffect(() => {
        fetch("https://esports-api.lolesports.com/persisted/gw/getLeagues?hl=en-US", {
            "method": "GET",
            "headers": {
                'Content-Type': 'application/json',
                'x-api-key': '0TvQnueqKa5mxJntVWt0w4LpLfEkrV1Ta8rQBb9Z'
            }
        }).then((res) => {
            return res.json();
        }).then((res) => {
            setLCKid(res.data.leagues[2].id)
        }).catch((error) => {
            console.log(error)
        })
    }, [])

    useEffect(() => {
        fetch("https://esports-api.lolesports.com/persisted/gw/getSchedule?hl=en-US&leagueId=" + LCKid, {
            "method": "GET",
            "headers": {
                'Content-Type': 'application/json',
                'x-api-key': '0TvQnueqKa5mxJntVWt0w4LpLfEkrV1Ta8rQBb9Z'
            }
        }).then((res) => {
            return res.json();
        }).then((res) => {
            let events = res.data.schedule.events;
            let maxLength = 8;
            for (let i = 0; i < events.length; i++) {
                if (events[i].state == "unstarted" && maxLength > 0 && stuff.length < 8) {
                    setStuff((oldArray) => [...oldArray, events[i].match.id])
                    maxLength--;
                }
            }
        }).catch((error) => {
            console.log(error);
        })
    }, [LCKid])

    useEffect(() => {
        console.log(stuff)
    }, [stuff])

    return (<>
        <NavBar/>
        <div id="container">
            <h2 id="upcoming-header">Upcoming Matches</h2>
            <UpcomingMatch matchid={stuff[0]} />
            <UpcomingMatch matchid={stuff[1]} />
            <UpcomingMatch matchid={stuff[2]} />
            <UpcomingMatch matchid={stuff[3]} />
        </div>
    </>)
}

export default Schedule;