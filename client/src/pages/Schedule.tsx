import NavBar from "../components/navbar";
import { useState, useEffect } from 'react'
import '../styles/schedule.css'

import UpcomingMatch from "../components/upcomingMatch";

interface upcomingMatchObj {
    matchid: number,
    time: string
}

const Schedule = () => {

    const [stuff, setStuff] = useState<number[]>([]);
    const [starts, setStarts] = useState<string[]>([]);
    const [LCKid, setLCKid] = useState<number>(0);

    // sets LCK League Id
    useEffect(() => {
        setStuff([]);
        fetch("https://esports-api.lolesports.com/persisted/gw/getLeagues?hl=en-US", {
            "method": "GET",
            "headers": {
                'Content-Type': 'application/json',
                'x-api-key': '0TvQnueqKa5mxJntVWt0w4LpLfEkrV1Ta8rQBb9Z'
            }
        }).then((res) => {
            return res.json();
        }).then((res) => {
            setLCKid(res.data.leagues[4].id)
        }).catch((error) => {
            console.log(error)
        })
    }, []);

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
            let maxLength = 5;
            for (let i = 0; i < events.length; i++) {
                if (events[i].state == "unstarted" && maxLength > 0 && stuff.length < maxLength) {
                    // console.log(i + " " + events[i].match.id + " " + events[i].startTime);
                    setStuff((oldArray) => [...oldArray, events[i].match.id]);
                    setStarts((prev) => [...prev, events[i].startTime]);
                    maxLength--;
                }
            }
        }).catch((error) => {
            console.log(error);
        })
    }, [LCKid]);

    useEffect(() => {
        // console.log(stuff);
    }, [stuff])

    return (<>
        <NavBar/>
        <div id="container">
        <h2 id="upcoming-header">Upcoming Matches</h2>
            <div id="schedule-inner-container">
                {stuff.map((val, i) => {
                    return (<UpcomingMatch matchid={val} time={starts[i]} />)
                })}
            </div>
        </div>
    </>)
};

export default Schedule;
export type { upcomingMatchObj };