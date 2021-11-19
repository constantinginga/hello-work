using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data
{
    interface IJobListingData
    {
        Task<JobListing> CreateJobListing(JobListing jobListing);
        Task RemoveJobListing(string id);

        Task<IList<JobListing>> GetJobListings();

        Task<JobListing> GetJobListing(int id);

        Task UpdateJobListing(JobListing jobListing);
    }
}