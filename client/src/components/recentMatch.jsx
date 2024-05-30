import '../styles/recentMatch.css'
import { useState, useEffect } from 'react'

const recentMatch = (matchId) => {

    const [team1, setTeam1] = useState();
    const [team2, setTeam2] = useState();
    const [team1Score, setTeam1Score] = useState();
    const [team2Score, setTeam2Score] = useState();

    useEffect(() => {
        fetch("https://esports-api.lolesports.com/persisted/gw/getEventDetails?hl=en-US&id=" + matchId.matchid, {
            "method": "GET",
            "headers": {
                'Content-Type': 'application/json',
                'x-api-key': '0TvQnueqKa5mxJntVWt0w4LpLfEkrV1Ta8rQBb9Z'
            }
        }).then((res) => {
            return res.json()
        }).then((res) => {
            const match = res.data.event.match
            setTeam1(match.teams[0].code);
            setTeam2(match.teams[1].code);
            setTeam1Score(match.teams[0].result.gameWins);
            setTeam2Score(match.teams[1].result.gameWins);
        }).catch((error) => {
            console.log(error)
        })
    })

    
    return(
        <div className='singleMatch-container'>
            <h2>{team1}  {team1Score} - {team2Score}  {team2}</h2>
            <p>{matchId.startTime}</p>
        </div>
        )
}

export default recentMatch; 