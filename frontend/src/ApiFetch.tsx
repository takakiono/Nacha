import React, { useState, useEffect } from "react";

interface Stone {
    month: string;
    color: string;
    name: string;
}

export const ApiFetch = () => {
    const [stone, setStone] = useState<Stone | null>(null);

    useEffect(() => {
        fetch("http://0.0.0.0:8801/api", { method: "GET" })
            .then((res) => res.json())
            .then((data) => {
                setStone(data);
            });
    }, []);

    return (
        <div>
            {stone ? (
                <div>
                    <div>Month: {stone.month}</div>
                    <div>Color: {stone.color}</div>
                    <div>Name: {stone.name}</div>
                </div>
            ) : (
                <div>No stone available</div>
            )}
        </div>
    );
};
