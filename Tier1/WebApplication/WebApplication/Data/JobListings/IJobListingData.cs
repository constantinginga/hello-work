using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data
{
    interface IJobListingData
    {
        Task<JobListing>  Create(JobListing jobListing);
        Task<IList<JobListing>> GetJobListings();

        Task<JobListing> Get(int id);

        Task Update(JobListing jobListing);
    }
}
