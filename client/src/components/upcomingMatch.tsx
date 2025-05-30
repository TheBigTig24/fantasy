import { useState, useEffect } from 'react';
import '../styles/upcomingMatch.css';
import { upcomingMatchObj } from '../pages/Schedule';

const UpcomingMatch = (matchId: upcomingMatchObj) => {

    const [teamOne, setTeamOne] = useState<string>("");
    const [teamTwo, setTeamTwo] = useState<string>("");
    const [numGames, setNumGames] = useState<number>(0);
    const [logoOne, setLogoOne] = useState<string>("");
    const [logoTwo, setLogoTwo] = useState<string>("");
    const [leagueName, setLeagueName] = useState<string>("");
    const [time, setTime] = useState<string>("");

    const months = ["Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."];

    useEffect(() => {
        // convert time to display
        const monthNum: number = parseInt(matchId.time.substring(5,7));
        const month = months[monthNum - 1];
        let time = matchId.time.substring(11, 16);
        let hour = parseInt(time.substring(0,2));
        let isAm = true;
        if (hour > 12) {
            hour -= 12;
            isAm = false;
        }
        setTime(month + " " + matchId.time.substring(8, 10) + ", " + matchId.time.substring(0,4) + " | " + hour + matchId.time.substring(13, 16) + (isAm ? "AM" : "PM"));

        //fetch event details
        const url = "https://esports-api.lolesports.com/persisted/gw/getEventDetails?hl=en-US&id=" + matchId.matchid;
        fetch(url, {
            "method": "GET",
            "headers": {
                'Content-Type': 'application/json',
                'x-api-key': '0TvQnueqKa5mxJntVWt0w4LpLfEkrV1Ta8rQBb9Z'
            }
        }).then((res) => {
            return res.json();
        }).then((res) => {
            setTeamOne(res.data.event.match.teams[0].code);
            setTeamTwo(res.data.event.match.teams[1].code);
            setNumGames(res.data.event.match.strategy.count);
            setLogoOne(res.data.event.match.teams[0].image);
            setLogoTwo(res.data.event.match.teams[1].image);
            setLeagueName(res.data.event.league.name);
        }).catch((error) => {
            console.log(error);
        })
    });



    return(
        <div id='upcoming-match-container'>
            <p id='p-tag'>{teamOne} <img id='logo' src={logoOne}></img> vs <img id='logo' src={logoTwo}></img> {teamTwo}</p>
            <p>Best Of {numGames}</p>
            <p>{leagueName} {time}</p>
        </div>
    )
};

export default UpcomingMatch;