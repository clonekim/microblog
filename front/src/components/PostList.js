import React, { useState, useEffect } from 'react';
import { useQuery } from '@apollo/client';
import { Card, } from 'react-bootstrap';

import { loader } from 'graphql.macro';
const GET_POSTS = loader('../graphql/query-posts.graphql');

function PostList () {
  const [page, setPage] = useState(1)
  const [posts, setPosts] = useState([]);

  const {loading, error, data} = useQuery(GET_POSTS, {
    variables: {page: 1}
  });


  return (
    <div>{posts}</div>
  );




};

export default PostList;
