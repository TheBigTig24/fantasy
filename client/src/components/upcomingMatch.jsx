import { useState, useEffect } from 'react';
import '../styles/upcomingMatch.css';

const UpcomingMatch = (matchId) => {

    const [teamOne, setTeamOne] = useState();
    const [teamTwo, setTeamTwo] = useState();
    const [numGames, setNumGames] = useState();

    useEffect(() => {
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
        }).catch((error) => {
            console.log(error);
        })
    });



    return(
        <div id='upcoming-match-container'>
            <p id='p-tag'>{teamOne} VS {teamTwo} in a Best Of {numGames}</p>
        </div>
    )
};

export default UpcomingMatch;