import '../styles/home.css'
import NavBar from '../components/navbar'
import RecentMatch from '../components/recentMatch'
import { useState, useEffect } from 'react'

const Home = () => {

    const [LCKid, setLCKid] = useState();
    const [lastThree, setLastThree] = useState([]);
    const [lastThreeTimes, setLastThreeTimes] = useState([]);
    const [months, setMonths] = useState(["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]);

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
            console.log(res.data.leagues)
            setLCKid(res.data.leagues[3].id)
        }).catch((error) => {
            console.log(error)
        })
    }, [])

    // gets match Ids of last three completed matches in LCK
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
            const eventArr = res.data.schedule.events
            if (lastThree.length < 3) {
                let count = 3;
                for (let i = eventArr.length - 1; i >= 0; i--) {
                    if (eventArr[i].state == "completed" && count != 0) {
                        setLastThree((oldArray) => [...oldArray, eventArr[i].match.id]);
                        setLastThreeTimes((oldArray) => [...oldArray, convertTime(eventArr[i].startTime.substring(0,10))])
                        count--;
                    }
                }
            }
        }).catch((error) => {
            console.log(error)
        })
    }, [LCKid])

    // logs the last three completed matches' ids
    useEffect(() => {
    }, [lastThree])

    // convert date format
    function convertTime(originalFormat) {
        const month = months[parseInt(originalFormat.substring(5,7)) - 1]
        const day = parseInt(originalFormat.substring(8,10))
        const year = parseInt(originalFormat.substring(0,4))

        return month + " " + day + ", " + year
    }

    return(<>
        <NavBar />
        <div className='contain'>
            <div className='user-matches'>
                <div className='user-matches-inner'>
                    <h1>Your Servers</h1>
                    <button id='create-server'></button>
                </div>
            </div>
            <div className='recent-matches'>
                <h1>Recent Matches</h1>
                <RecentMatch matchid={lastThree[0]} startTime={lastThreeTimes[0]} />
                <RecentMatch matchid={lastThree[1]} startTime={lastThreeTimes[1]} />
                <RecentMatch matchid={lastThree[2]} startTime={lastThreeTimes[2]} />
            </div>
        </div>
    </>)
}

export default Home;