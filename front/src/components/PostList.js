import React, { useState, useEffect } from 'react';
import {gql, useQuery } from '@apollo/client';
import { Card, } from 'react-bootstrap';

import { loader } from 'graphql.macro';
const GET_POSTS = loader('../graphql/query-posts.graphql');

function PostList () {
  const [page, setPage] = useState(1)
  const [posts, setPosts] = useState([]);

  const {loading, error, data} = useQuery(GET_POSTS, {
    variables: {page: page}
  });


  return (
    <div>{posts}</div>
  );




};

export default PostList;
