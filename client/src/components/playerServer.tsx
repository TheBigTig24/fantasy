import { useState } from 'react';
import '../styles/playerServer.css';

const PlayerServer = () => {

    const [serverName, setServerName] = useState<string>("Diddy Party");
    const [weeklyPoints, setWeeklyPoints] = useState<number>(140.5);

    return(<button id='player-server-container'>
        <div id='ps-inner'>
            <p id='server-name'>{serverName}</p>
            <p>Your points: {weeklyPoints}</p>
        </div>
    </button>)
};

export default PlayerServer;